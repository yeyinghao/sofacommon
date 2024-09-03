/*
 * QQ: 1113531030 WX: missyeyh Phone: 17689397484 Copyright (c) Ye Yinghao 2022.1 - 2023.2
 */

package com.luman.sofasmy.util.enums;

/**
 * 通过代码
 *
 * @author yeyinghao
 * @date 2024/08/26
 */
public interface ByCode<T> {

	/**
	 * 获取代码
	 *
	 * @return {@link String }
	 */
	T getCode();

	/**
	 * 获取描述
	 *
	 * @return {@link String}
	 */
	String getDesc();
}
