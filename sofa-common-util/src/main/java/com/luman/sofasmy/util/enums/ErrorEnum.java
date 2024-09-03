package com.luman.sofasmy.util.enums;

import com.luman.sofasmy.util.constant.HttpConstant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 通用错误枚举
 *
 * @author yeyinghao
 * @date 2024/04/04
 */
@Getter
@RequiredArgsConstructor
@ToString
public enum ErrorEnum implements ByErrorCode {

	/**
	 * 成功
	 */
	SUCCESS("SUCCESS", HttpConstant.OK, "成功"),

	/**
	 * 参数非法
	 */
	ILLEGAL_PARAMETER("ILLEGAL_PARAMETER", HttpConstant.BAD_REQUEST, "参数非法"),

	/**
	 * 业务异常
	 */
	BIZ_ERROR("BIZ_ERROR", HttpConstant.BAD_REQUEST, "业务异常"),

	/**
	 * 未授权
	 */
	FORBIDDEN("FORBIDDEN", HttpConstant.FORBIDDEN, "未授权"),

	/**
	 * 资源未找到
	 */
	NOT_FOUND("NOT_FOUND", HttpConstant.NOT_FOUND, "资源未找到"),

	/**
	 * 服务内部错误
	 */
	SYS_ERROR("SYS_ERROR", HttpConstant.INTERNAL_SERVER_ERROR, "系统错误"),

	/**
	 * 服务不可用
	 */
	SERVICE_UNAVAILABLE("SERVICE_UNAVAILABLE", HttpConstant.SERVICE_UNAVAILABLE, "服务不可用"),

	;

	/**
	 * 响应码
	 */
	private final String code;

	/**
	 * 响应码
	 */
	private final Integer httpCode;

	/**
	 * 响应业务码的描述
	 */
	private final String desc;
}
