/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.12
 */

package com.luman.sofasmy.util.exception;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.luman.sofasmy.util.enums.ByErrorCode;

import java.util.Map;
import java.util.Objects;

/**
 * 断言
 *
 * @author yeyinghao
 * @date 2023/12/10
 */
@SuppressWarnings("unused")
public abstract class CheckUtil {

	/**
	 * 条件为false, 则抛异常
	 *
	 * @param condition 条件
	 * @param errorCode 错误代码
	 */
	public static void isTrue(boolean condition, ByErrorCode errorCode) {
		if (!condition) {
			ThrowUtil.throwEx(errorCode, "[Assertion failed] Must be true");
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
			ThrowUtil.throwEx(errorCode, subMessage);
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
			ThrowUtil.throwEx(errorCode, StrUtil.format(template, subMessages));
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
			ThrowUtil.throwEx(errorCode, "[Assertion failed] Must be false");
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
			ThrowUtil.throwEx(errorCode, subMessage);
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
			ThrowUtil.throwEx(errorCode, StrUtil.format(template, subMessages));
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
			ThrowUtil.throwEx(errorCode, "[Assertion failed] Must not null");
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
			ThrowUtil.throwEx(errorCode, subMessage);
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
			ThrowUtil.throwEx(errorCode, StrUtil.format(template, subMessages));
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
			ThrowUtil.throwEx(errorCode, "[Assertion failed] Must be null");
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
			ThrowUtil.throwEx(errorCode, subMessage);
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
			ThrowUtil.throwEx(errorCode, StrUtil.format(template, subMessages));
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
			ThrowUtil.throwEx(errorCode, "[Assertion failed] Must not blank");
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
			ThrowUtil.throwEx(errorCode, subMessage);
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
			ThrowUtil.throwEx(errorCode, StrUtil.format(template, subMessages));
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
			ThrowUtil.throwEx(errorCode, "[Assertion failed] Collection must not be empty: it must contain at least 1 element");
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
			ThrowUtil.throwEx(errorCode, subMessage);
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
			ThrowUtil.throwEx(errorCode, StrUtil.format(template, subMessages));
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
			ThrowUtil.throwEx(errorCode, "[Assertion failed] Map must not be empty: it must contain at least one entry");
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
			ThrowUtil.throwEx(errorCode, subMessage);
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
			ThrowUtil.throwEx(errorCode, StrUtil.format(template, subMessages));
		}
	}
}
