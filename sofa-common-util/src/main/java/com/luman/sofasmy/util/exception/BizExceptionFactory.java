package com.luman.sofasmy.util.exception;


import com.luman.sofasmy.util.enums.ByErrorCode;

public class BizExceptionFactory {

	/**
	 * 业务异常
	 *
	 * @param errorEnum 错误枚举
	 * @return {@link BizException }
	 */
	public static BizException buildBizException(ByErrorCode errorEnum) {
		return new BizException(errorEnum);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum    错误枚举
	 * @param errorMessage 错误消息
	 * @return {@link BizException }
	 */
	public static BizException buildBizException(ByErrorCode errorEnum, String errorMessage) {
		return new BizException(errorEnum, errorMessage);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum 错误枚举
	 * @param throwable throwable
	 * @return {@link BizException }
	 */
	public static BizException buildBizException(ByErrorCode errorEnum, Throwable throwable) {
		return new BizException(errorEnum, throwable);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum    错误枚举
	 * @param throwable    throwable
	 * @param errorMessage 错误消息
	 * @return {@link BizException }
	 */
	public static BizException buildBizException(ByErrorCode errorEnum, Throwable throwable, String errorMessage) {
		return new BizException(errorEnum, errorMessage, throwable);
	}

}
