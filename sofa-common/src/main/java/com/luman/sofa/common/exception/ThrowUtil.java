package com.luman.sofa.common.exception;

import cn.hutool.core.util.StrUtil;
import com.luman.sofa.common.enums.ByErrorCode;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ThrowUtil {

	/**
	 * 业务异常
	 *
	 * @param errorEnum 错误枚举
	 */
	public static void throwEx(ByErrorCode errorEnum) {
		throw BizExceptionFactory.build(errorEnum);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum  错误枚举
	 * @param subMessage 错误消息
	 */
	public static void throwEx(ByErrorCode errorEnum, String subMessage) {
		throw BizExceptionFactory.build(errorEnum, subMessage);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum   错误枚举
	 * @param subMessages 错误消息
	 */
	public static void throwEx(ByErrorCode errorEnum, String template, Object... subMessages) {
		throw BizExceptionFactory.build(errorEnum, StrUtil.format(template, subMessages));
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum 错误枚举
	 */
	public static void throwEx(ByErrorCode errorEnum, Throwable throwable) {
		throw BizExceptionFactory.build(errorEnum, throwable);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum  错误枚举
	 * @param subMessage 错误消息
	 */
	public static void throwEx(ByErrorCode errorEnum, Throwable throwable, String subMessage) {
		throw BizExceptionFactory.build(errorEnum, throwable, subMessage);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum   错误枚举
	 * @param subMessages 错误消息
	 */
	public static void throwEx(ByErrorCode errorEnum, Throwable throwable, String template, Object... subMessages) {
		throw BizExceptionFactory.build(errorEnum, throwable, StrUtil.format(template, subMessages));
	}
}
