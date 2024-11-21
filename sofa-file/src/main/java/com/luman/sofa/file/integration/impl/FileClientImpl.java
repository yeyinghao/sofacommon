/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.10
 */

package com.luman.sofa.file.integration.impl;

import cn.hutool.core.io.IoUtil;
import cn.hutool.http.Header;
import com.luman.sofa.common.constant.LoggerConstant;
import com.luman.sofa.common.enums.ErrorEnum;
import com.luman.sofa.common.exception.VarChecker;
import com.luman.sofa.common.monitor.log.Logged;
import com.luman.sofa.file.integration.FileClient;
import com.luman.sofa.file.integration.config.FileConfig;
import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import io.minio.messages.Item;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 文件服务实现
 *
 * @author yeyinghao
 * @date 2023/09/17
 */
@Service
@RequiredArgsConstructor
@Logged(topic = LoggerConstant.FILE_LOG)
public class FileClientImpl implements FileClient {

	/**
	 * minio客户端
	 */
	private final MinioClient minioClient;

	/**
	 * minio配置
	 */
	private final FileConfig minioConfig;

	@SneakyThrows
	@Override
	public void uploadFile(String objectName, String fileName, byte[] content) {
		InputStream inputStream = null;
		try {
			inputStream = new ByteArrayInputStream(content);
			VarChecker.notBlank(fileName, ErrorEnum.BIZ_ERROR, "文件名称不能为空");
			// 下载文件时自动添加文件名
			Map<String, String> headers = new HashMap<>();
			String encodFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
			headers.put(Header.CONTENT_DISPOSITION.getValue(), "attachment;filename=" + encodFileName);
			PutObjectArgs putObjectArgs = PutObjectArgs.builder()
					.bucket(minioConfig.getBucketName()).object(objectName)
					.stream(inputStream, -1, minioConfig.getFileSize())
					.headers(headers).build();
			minioClient.putObject(putObjectArgs);
		} finally {
			IoUtil.close(inputStream);
		}
	}

	@Override
	@SneakyThrows
	public String getUploadFileUrl(String objectName) {
		return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
				.method(Method.PUT).bucket(minioConfig.getBucketName())
				.object(objectName).expiry(3600).build());
	}

	@Override
	@SneakyThrows
	public String getObjectFileUrl(String objectName, Long expiry) {
		return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
				.method(Method.GET).bucket(minioConfig.getBucketName())
				.object(objectName).expiry(expiry.intValue()).build());
	}

	@Override
	@SneakyThrows
	public byte[] downloadObject(String objectName) {
		InputStream inputStream = null;
		try {
			inputStream = minioClient.getObject(GetObjectArgs.builder()
					.bucket(minioConfig.getBucketName()).object(objectName).build());
			return IoUtil.readBytes(inputStream);
		} finally {
			IoUtil.close(inputStream);
		}
	}

	@Override
	@SneakyThrows
	public StatObjectResponse statObject(String objectName) {
		return minioClient.statObject(StatObjectArgs.builder().bucket(minioConfig.getBucketName())
				.object(objectName).build());
	}

	@Override
	public void removeListObject(List<String> objectNameList) {
		List<DeleteObject> objects = new LinkedList<>();
		for (String objectName : objectNameList) {
			objects.add(new DeleteObject(objectName));
		}
		Iterable<Result<DeleteError>> results = minioClient.removeObjects(RemoveObjectsArgs.builder()
				.bucket(minioConfig.getBucketName()).objects(objects).build());
		VarChecker.notEmpty(results, ErrorEnum.BIZ_ERROR, "批量删除失败");
	}

	@Override
	@SneakyThrows
	public List<String> listObjectNames() {
		List<String> listObjectNames = new ArrayList<>();
		Iterable<Result<Item>> myObjects = minioClient.listObjects(ListObjectsArgs.builder()
				.bucket(minioConfig.getBucketName()).build());
		for (Result<Item> result : myObjects) {
			Item item = result.get();
			listObjectNames.add(item.objectName());
		}
		return listObjectNames;
	}
}
