package com.luman.sofasmy.util.exception;

import cn.hutool.core.util.StrUtil;
import com.luman.sofasmy.util.enums.ByErrorCode;

public class ThrowUtil {

	/**
	 * 业务异常
	 *
	 * @param errorEnum 错误枚举
	 */
	public static void throwEx(ByErrorCode errorEnum) {
		throw BizExceptionFactory.buildBizException(errorEnum);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum  错误枚举
	 * @param subMessage 错误消息
	 */
	public static void throwEx(ByErrorCode errorEnum, String subMessage) {
		throw BizExceptionFactory.buildBizException(errorEnum, subMessage);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum   错误枚举
	 * @param subMessages 错误消息
	 */
	public static void throwEx(ByErrorCode errorEnum, String template, Object... subMessages) {
		throw BizExceptionFactory.buildBizException(errorEnum, StrUtil.format(template, subMessages));
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum 错误枚举
	 */
	public static void throwEx(ByErrorCode errorEnum, Throwable throwable) {
		throw BizExceptionFactory.buildBizException(errorEnum, throwable);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum  错误枚举
	 * @param subMessage 错误消息
	 */
	public static void throwEx(ByErrorCode errorEnum, Throwable throwable, String subMessage) {
		throw BizExceptionFactory.buildBizException(errorEnum, throwable, subMessage);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum   错误枚举
	 * @param subMessages 错误消息
	 */
	public static void throwEx(ByErrorCode errorEnum, Throwable throwable, String template, Object... subMessages) {
		throw BizExceptionFactory.buildBizException(errorEnum, throwable, StrUtil.format(template, subMessages));
	}
}
