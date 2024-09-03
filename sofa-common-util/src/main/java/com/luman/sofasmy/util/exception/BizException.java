package com.luman.sofasmy.util.exception;

import com.luman.sofasmy.util.constant.HttpConstant;
import com.luman.sofasmy.util.enums.ByErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 业务异常
 *
 * @author yeyinghao
 * @date 2023/08/01
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException {

	/**
	 * http状态
	 */
	private static final List<Integer> HTTP_STATUSES = Arrays.asList(HttpConstant.INTERNAL_SERVER_ERROR,
			HttpConstant.SERVICE_UNAVAILABLE);

	/**
	 * 基本枚举
	 */
	private final ByErrorCode byErrorCode;

	/**
	 * 业务异常
	 *
	 * @param byErrorCode 错误枚举
	 */
	public BizException(ByErrorCode byErrorCode) {
		super(byErrorCode.getDesc());
		this.byErrorCode = byErrorCode;
	}

	/**
	 * 业务异常
	 *
	 * @param byErrorCode 基本枚举
	 * @param message   子消息
	 */
	public BizException(ByErrorCode byErrorCode, String message) {
		super(message);
		this.byErrorCode = byErrorCode;
	}

	/**
	 * 业务异常
	 *
	 * @param byErrorCode 错误枚举
	 * @param ex        异常
	 */
	public BizException(ByErrorCode byErrorCode, Throwable ex) {
		super(byErrorCode.getDesc(), ex);
		this.byErrorCode = byErrorCode;
	}

	/**
	 * 业务异常
	 *
	 * @param byErrorCode 错误枚举
	 * @param message   消息
	 * @param ex        异常
	 */
	public BizException(ByErrorCode byErrorCode, String message, Throwable ex) {
		super(message, ex);
		this.byErrorCode = byErrorCode;
	}

	@Override
	public String toString() {
		return "SmyBizException{" +
				"byErrorCode=" + byErrorCode +
				", message=" + getMessage() +
				'}';
	}

	/**
	 * 是错误
	 *
	 * @return boolean
	 */
	public boolean isError() {
		return HTTP_STATUSES.contains(byErrorCode.getCode());
	}
}
