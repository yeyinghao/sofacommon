/*
 * QQ: 1113531030 WX: missyeyh Phone: 17689397484 Copyright (c) Ye Yinghao 2022.1 - 2023.2
 */

package com.luman.sofa.dto.enums;

import com.luman.sofa.dto.EnumVO;

import java.util.Optional;

/**
 * 通过代码
 *
 * @author yeyinghao
 * @date 2024/08/26
 */
public interface ByCode<T> {

	/**
	 * 获取名称
	 */
	default <M extends ByStringCode> String getName(M byCode) {
		return Optional.ofNullable(byCode).map(ByStringCode::getCode).orElse(null);
	}

	/**
	 * enum2vo
	 *
	 * @param byCode
	 * @return {@link EnumVO }
	 */
	default <M extends ByStringCode> EnumVO enum2VO(M byCode) {
		return Optional.ofNullable(byCode).map(this::buildEnumVO).orElse(null);
	}

	/**
	 * 构建enumvo
	 *
	 * @param byCode
	 * @return {@link EnumVO }
	 */
	private  <M extends ByCode<T>, T> EnumVO buildEnumVO(M byCode) {
		EnumVO enumVO = new EnumVO();
		enumVO.setCode(String.valueOf(byCode.getCode()));
		enumVO.setDesc(byCode.getDesc());
		return enumVO;
	}


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
