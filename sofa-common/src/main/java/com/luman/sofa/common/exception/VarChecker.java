/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.12
 */

package com.luman.sofa.common.exception;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.luman.sofa.model.enums.ByErrorCode;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.Objects;

/**
 * 断言
 *
 * @author yeyinghao
 * @date 2023/12/10
 */
@SuppressWarnings("unused")
@UtilityClass
public class VarChecker {

	/**
	 * 业务异常
	 *
	 * @param errorEnum 错误枚举
	 */
	private void throwEx(ByErrorCode errorEnum) {
		throw BizExceptionFactory.build(errorEnum);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum  错误枚举
	 * @param subMessage 错误消息
	 */
	private void throwEx(ByErrorCode errorEnum, String subMessage) {
		throw BizExceptionFactory.build(errorEnum, subMessage);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum   错误枚举
	 * @param subMessages 错误消息
	 */
	private void throwEx(ByErrorCode errorEnum, String template, Object... subMessages) {
		throw BizExceptionFactory.build(errorEnum, template, subMessages);
	}


	/**
	 * 条件为false, 则抛异常
	 *
	 * @param condition 条件
	 * @param errorCode 错误代码
	 */
	public static void isTrue(boolean condition, ByErrorCode errorCode) {
		if (!condition) {
			throwEx(errorCode);
		}
	}

	/**
	 * 条件为false, 则抛异常
	 *
	 * @param condition  条件
	 * @param errorCode  错误代码
	 * @param subMessage 子消息
	 */
	public static void isTrue(boolean condition, ByErrorCode errorCode, String subMessage) {
		if (!condition) {
			throwEx(errorCode, subMessage);
		}
	}

	/**
	 * 条件为false, 则抛异常
	 *
	 * @param condition   条件
	 * @param errorCode   错误代码
	 * @param template    模板
	 * @param subMessages 子消息
	 */
	public static void isTrue(boolean condition, ByErrorCode errorCode, String template, Object... subMessages) {
		if (!condition) {
			throwEx(errorCode, template, subMessages);
		}
	}

	/**
	 * 条件为true, 则抛异常
	 *
	 * @param condition 条件
	 * @param errorCode 错误代码
	 */
	public static void isFalse(boolean condition, ByErrorCode errorCode) {
		if (condition) {
			throwEx(errorCode);
		}
	}

	/**
	 * 条件为true, 则抛异常
	 *
	 * @param condition  条件
	 * @param errorCode  错误代码
	 * @param subMessage 子消息
	 */
	public static void isFalse(boolean condition, ByErrorCode errorCode, String subMessage) {
		if (condition) {
			throwEx(errorCode, subMessage);
		}
	}

	/**
	 * 条件为true, 则抛异常
	 *
	 * @param condition   条件
	 * @param errorCode   错误代码
	 * @param template    模板
	 * @param subMessages 子消息
	 */
	public static void isFalse(boolean condition, ByErrorCode errorCode, String template, Object... subMessages) {
		if (condition) {
			throwEx(errorCode, template, subMessages);
		}
	}

	/**
	 * 对象为null, 则抛异常
	 *
	 * @param obj       obj
	 * @param errorCode 错误代码
	 */
	public static void notNull(Object obj, ByErrorCode errorCode) {
		if (Objects.isNull(obj)) {
			throwEx(errorCode);
		}
	}

	/**
	 * 对象为null, 则抛异常
	 *
	 * @param obj        obj
	 * @param errorCode  错误代码
	 * @param subMessage 子消息
	 */
	public static void notNull(Object obj, ByErrorCode errorCode, String subMessage) {
		if (Objects.isNull(obj)) {
			throwEx(errorCode, subMessage);
		}
	}

	/**
	 * 对象为null, 则抛异常
	 *
	 * @param obj         obj
	 * @param errorCode   错误代码
	 * @param template    模板
	 * @param subMessages 子消息
	 */
	public static void notNull(Object obj, ByErrorCode errorCode, String template, Object... subMessages) {
		if (Objects.isNull(obj)) {
			throwEx(errorCode, template, subMessages);
		}
	}

	/**
	 * 对象非null, 则抛异常
	 *
	 * @param obj       obj
	 * @param errorCode 错误代码
	 */
	public static void isNull(Object obj, ByErrorCode errorCode) {
		if (Objects.nonNull(obj)) {
			throwEx(errorCode);
		}
	}

	/**
	 * 对象非null, 则抛异常
	 *
	 * @param obj        obj
	 * @param errorCode  错误代码
	 * @param subMessage 子消息
	 */
	public static void isNull(Object obj, ByErrorCode errorCode, String subMessage) {
		if (Objects.nonNull(obj)) {
			throwEx(errorCode, subMessage);
		}
	}

	/**
	 * 对象非null, 则抛异常
	 *
	 * @param obj         obj
	 * @param errorCode   错误代码
	 * @param template    模板
	 * @param subMessages 子消息
	 */
	public static void isNull(Object obj, ByErrorCode errorCode, String template, Object... subMessages) {
		if (Objects.nonNull(obj)) {
			throwEx(errorCode, template, subMessages);
		}
	}

	/**
	 * 字符串为空, 则抛异常
	 *
	 * @param obj       obj
	 * @param errorCode 错误代码
	 */
	public static void notBlank(String obj, ByErrorCode errorCode) {
		if (Objects.nonNull(obj)) {
			throwEx(errorCode);
		}
	}

	/**
	 * 字符串为空, 则抛异常
	 *
	 * @param obj        obj
	 * @param errorCode  错误代码
	 * @param subMessage 子消息
	 */
	public static void notBlank(String obj, ByErrorCode errorCode, String subMessage) {
		if (StrUtil.isBlank(obj)) {
			throwEx(errorCode, subMessage);
		}
	}

	/**
	 * 字符串为空, 则抛异常
	 *
	 * @param obj         obj
	 * @param errorCode   错误代码
	 * @param template    模板
	 * @param subMessages 子消息
	 */
	public static void notBlank(String obj, ByErrorCode errorCode, String template, Object... subMessages) {
		if (StrUtil.isBlank(obj)) {
			throwEx(errorCode, template, subMessages);
		}
	}

	/**
	 * 集合为空, 则抛异常
	 *
	 * @param collection 集合
	 * @param errorCode  错误代码
	 */
	public static void notEmpty(Iterable<?> collection, ByErrorCode errorCode) {
		if (CollUtil.isEmpty(collection)) {
			throwEx(errorCode);
		}
	}

	/**
	 * 集合为空, 则抛异常
	 *
	 * @param collection 集合
	 * @param errorCode  错误代码
	 * @param subMessage 子消息
	 */
	public static void notEmpty(Iterable<?> collection, ByErrorCode errorCode, String subMessage) {
		if (CollUtil.isEmpty(collection)) {
			throwEx(errorCode, subMessage);
		}
	}

	/**
	 * 集合为空, 则抛异常
	 *
	 * @param collection  集合
	 * @param errorCode   错误代码
	 * @param template    模板
	 * @param subMessages 子消息
	 */
	public static void notEmpty(Iterable<?> collection, ByErrorCode errorCode, String template, Object... subMessages) {
		if (CollUtil.isEmpty(collection)) {
			throwEx(errorCode, template, subMessages);
		}
	}

	/**
	 * map为空, 则抛异常
	 *
	 * @param map       map集合
	 * @param errorCode 错误代码
	 */
	public static void notEmpty(Map<?, ?> map, ByErrorCode errorCode) {
		if (MapUtil.isEmpty(map)) {
			throwEx(errorCode);
		}
	}

	/**
	 * map为空, 则抛异常
	 *
	 * @param map        map集合
	 * @param errorCode  错误代码
	 * @param subMessage 子消息
	 */
	public static void notEmpty(Map<?, ?> map, ByErrorCode errorCode, String subMessage) {
		if (MapUtil.isEmpty(map)) {
			throwEx(errorCode, subMessage);
		}
	}

	/**
	 * map为空, 则抛异常
	 *
	 * @param map         map集合
	 * @param errorCode   错误代码
	 * @param template    模板
	 * @param subMessages 子消息
	 */
	public static void notEmpty(Map<?, ?> map, ByErrorCode errorCode, String template, Object... subMessages) {
		if (MapUtil.isEmpty(map)) {
			throwEx(errorCode, template, subMessages);
		}
	}
}
