/*
 * QQ: 1113531030 WX: missyeyh Phone: 17689397484 Copyright (c) Ye Yinghao 2022.1 - 2023.2
 */

package com.luman.sofasmy.util.enums;

/**
 * 通过错误代码
 *
 * @author yeyinghao
 * @date 2024/08/26
 */
public interface ByErrorCode extends ByStringCode {

	/**
	 * 获得状态码
	 *
	 * @return {@link Integer}
	 */
	Integer getHttpCode();
}
