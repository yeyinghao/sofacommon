/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.10
 */

package com.luman.sofa.file.service.impl;

import com.luman.sofa.common.utils.LoggerUtil;
import com.luman.sofa.file.integration.FileClient;
import com.luman.sofa.file.integration.model.FileStatInfo;
import com.luman.sofa.file.service.FileService;
import io.minio.StatObjectResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * 文件服务实现
 *
 * @author yeyinghao
 * @date 2023/09/17
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FileServiceImpl implements FileService {

	/**
	 * minio客户端
	 */
	private final FileClient fileClient;

	@Override
	public void uploadFile(String objectName, String fileName, byte[] content) {
		fileClient.uploadFile(objectName, fileName, content);
	}


	@Override
	public String getUploadFileUrl(String objectName) {
		return fileClient.getUploadFileUrl(objectName);
	}

	@Override
	public String getObjectFileUrl(String objectName, Long expiry) {
		return fileClient.getObjectFileUrl(objectName, expiry);
	}

	@Override
	public byte[] downloadObject(String objectName) {
		return fileClient.downloadObject(objectName);
	}

	@Override
	public FileStatInfo statObject(String objectName) {
		StatObjectResponse statObjectResponse = fileClient.statObject(objectName);
		return new FileStatInfo();
	}

	@Override
	public void removeListObject(List<String> objectNameList) {
		fileClient.removeListObject(objectNameList);
	}

	@Override
	public List<String> listObjectNames() {
		return fileClient.listObjectNames();
	}

	@Override
	public Boolean isExist(String objectName) {
		try {
			fileClient.statObject(objectName);
			return true;
		} catch (Throwable e) {
			LoggerUtil.info(log, e);
		}
		return false;
	}
}
