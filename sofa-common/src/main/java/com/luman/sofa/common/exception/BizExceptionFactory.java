package com.luman.sofa.common.exception;


import cn.hutool.core.util.StrUtil;
import com.luman.sofa.dto.enums.ByErrorCode;

/**
 * 业务exceptionfactory
 *
 * @author yeyinghao
 * @date 2024/09/04
 */
public class BizExceptionFactory {

	/**
	 * 业务异常
	 *
	 * @param errorEnum 错误枚举
	 * @return {@link BizException }
	 */
	public static BizException build(ByErrorCode errorEnum) {
		return new BizException(errorEnum);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum    错误枚举
	 * @param errorMessage 错误消息
	 * @return {@link BizException }
	 */
	public static BizException build(ByErrorCode errorEnum, String errorMessage) {
		return new BizException(errorEnum, errorMessage);
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum     错误枚举
	 * @param template
	 * @param errorMessages
	 * @return {@link BizException }
	 */
	public static BizException build(ByErrorCode errorEnum, String template, Object... errorMessages) {
		return new BizException(errorEnum, StrUtil.format(template, errorMessages));
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum 错误枚举
	 * @param throwable throwable
	 * @return {@link BizException }
	 */
	public static BizException build(ByErrorCode errorEnum, Throwable throwable) {
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
	public static BizException build(ByErrorCode errorEnum, Throwable throwable, String errorMessage) {
		return new BizException(errorEnum, errorMessage, throwable);
	}

	/**
	 * 构建业务exception
	 *
	 * @param errorEnum
	 * @param throwable
	 * @param template
	 * @param errorMessages
	 * @return {@link BizException }
	 */
	public static BizException build(ByErrorCode errorEnum, Throwable throwable, String template, Object... errorMessages) {
		return new BizException(errorEnum, StrUtil.format(template, errorMessages), throwable);
	}
}
