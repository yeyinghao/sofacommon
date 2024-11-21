/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.3
 */

package com.luman.sofa.file.integration.util;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
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
	 * @param userNo   用户代码
	 * @param bizNo    业务id
	 * @param fileName 文件名称
	 * @return {@link String}
	 */
	public static String createObjectName(FileTypeEnum fileType, String userNo, String bizNo, String fileName) {
		StringBuilder fileKey = new StringBuilder();
		String suffix = FileNameUtil.getSuffix(fileName);
		String uuid = IdUtil.fastSimpleUUID();
		String dateStr = DateUtil.format(LocalDateTime.now(), DatePattern.PURE_DATE_PATTERN);
		fileKey.append(fileType.getPath());
		if (StrUtil.isNotBlank(userNo)) {
			fileKey.append("/").append(userNo);
		}
		if (StrUtil.isNotBlank(bizNo)) {
			fileKey.append("/").append(bizNo);
		}
		fileKey.append("/").append(dateStr).append("/").append(uuid).append(".").append(suffix);
		return fileKey.toString();
	}
}
