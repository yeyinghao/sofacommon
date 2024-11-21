/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.sofa.cache.integration.enums;

import com.luman.sofa.dto.enums.ByStringCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 基础常数
 *
 * @author yeyinghao
 * @date 2024/04/04
 */
@Getter
@RequiredArgsConstructor
@ToString
public enum CalEnum implements ByStringCode {

	/**
	 * 获取对象
	 */
	GET("GET", "获取对象"),

	/**
	 * 保存对象
	 */
	SAVE("SAVE", "保存对象"),

	/**
	 * 保存对象,超时
	 */
	SAVE_EXPIRE("SAVE_EXPIRE", "保存对象,超时"),

	/**
	 * 尝试保存对象
	 */
	TRY_SAVE("TRY_SAVE", "尝试保存对象"),

	/**
	 * 尝试保存对象,超时
	 */
	TRY_SAVE_EXPIRE("TRY_SAVE_EXPIRE", "尝试保存对象,超时"),

	/**
	 * 删除对象
	 */
	DELETE("DELETE", "删除对象"),

	/**
	 * 判断对象是否存在
	 */
	IS_EXISTS("IS_EXISTS", "判断对象是否存在"),

	/**
	 * 获取List
	 */
	GET_LIST("GET_LIST", "获取List"),

	/**
	 * 获取MapCache
	 */
	GET_MAP_CACHE("GET_MAP_CACHE", "获取MapCache"),

	/**
	 * 获取Map
	 */
	GET_MAP("GET_MAP", "获取Map"),

	/**
	 * 获取Set
	 */
	GET_SET("GET_SET", "获取Set"),

	/**
	 * 获取ScoredSortedSet
	 */
	GET_SCORED_SORTED_SET("GET_SCORED_SORTED_SET", "获取ScoredSortedSet"),

	/**
	 * 获取锁
	 */
	GET_LOCK("GET_LOCK", "获取锁"),

	/**
	 * 获取对象剩余过期时间
	 */
	REMAIN_TIME_TO_LIVE("REMAIN_TIME_TO_LIVE", "获取对象剩余过期时间"),
	;


	/**
	 * 代码
	 */
	private final String code;

	/**
	 * 响应业务码的描述
	 */
	private final String desc;
}
