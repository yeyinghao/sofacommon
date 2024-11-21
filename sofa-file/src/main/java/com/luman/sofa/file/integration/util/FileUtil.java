/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.3
 */

package com.luman.sofa.file.integration.util;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.util.IdUtil;
import com.luman.sofa.file.integration.enums.FileTypeEnum;

import java.time.LocalDateTime;

/**
 * 文件工具类
 *
 * @author yeyinghao
 * @date 2024/03/31
 */
public class FileUtil {

	/**
	 * 创建文件key
	 *
	 * @param fileType 文件类型
	 * @param userCode 用户代码
	 * @param bizId    业务id
	 * @param fileName 文件名称
	 * @return {@link String}
	 */
	public static String createObjectName(FileTypeEnum fileType, String userCode, String bizId, String fileName) {
		StringBuilder sb = new StringBuilder();
		String suffix = FileNameUtil.getSuffix(fileName);
		String uuid = IdUtil.fastSimpleUUID();
		String dateStr = DateUtil.format(LocalDateTime.now(), DatePattern.PURE_DATE_PATTERN);
		sb.append(fileType.getPath()).append(userCode).append("/").append(bizId)
				.append("/").append(dateStr).append("/").append(uuid).append(".").append(suffix);
		return sb.toString();
	}
}
