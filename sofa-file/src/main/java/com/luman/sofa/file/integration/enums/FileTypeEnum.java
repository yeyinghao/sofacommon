/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.12
 */

package com.luman.sofa.file.integration.enums;

import com.luman.sofa.model.enums.ByStringCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 文件类型enum
 *
 * @author yeyinghao
 * @date 2024/04/04
 */
@Getter
@RequiredArgsConstructor
@ToString
public enum FileTypeEnum implements ByStringCode {

	/**
	 * 业务文件
	 */
	BIZ("BIZ", "biz", "业务文件"),

	/**
	 * 临时文件
	 */
	TEMPORARY("TEMPORARY", "temporary", "临时文件"),

	;

	/**
	 * 路径
	 */
	private final String code;

	/**
	 * 路径
	 */
	private final String path;

	/**
	 * 响应业务码的描述
	 */
	private final String desc;

}
