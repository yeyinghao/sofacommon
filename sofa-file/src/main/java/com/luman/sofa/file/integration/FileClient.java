/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.10
 */

package com.luman.sofa.file.integration;

import io.minio.StatObjectResponse;

import java.io.InputStream;
import java.util.List;

/**
 * 文件服务
 *
 * @author yeyinghao
 * @date 2024/03/31
 */
public interface FileClient {

	/**
	 * 上传文件
	 *
	 * @param fileKey     文件key
	 * @param fileName    文件名称
	 * @param content 输入流
	 */
	void uploadFile(String fileKey, String fileName, byte[] content);

	/**
	 * 获取上传文件url
	 *
	 * @param fileKey 对象名称
	 * @return {@link String}
	 */
	String getUploadFileUrl(String fileKey);

	/**
	 * 得到对象文件url
	 *
	 * @param fileKey 对象名称
	 * @param expiry     到期
	 * @return {@link String}
	 */
	String getObjectFileUrl(String fileKey, Long expiry);

	/**
	 * 下载对象
	 *
	 * @param fileKey 对象名称
	 * @return {@link InputStream}
	 */
	byte[] downloadObject(String fileKey);

	/**
	 * 统计对象
	 *
	 * @param fileKey 对象名称
	 * @return {@link StatObjectResponse}
	 */
	StatObjectResponse statObject(String fileKey);

	/**
	 * 删除列表对象
	 *
	 * @param objectNameList 对象名称列表
	 */
	void removeListObject(List<String> objectNameList);

	/**
	 * 列出对象名称
	 *
	 * @return {@link List}<{@link String}>
	 */
	List<String> listObjectNames();
}
