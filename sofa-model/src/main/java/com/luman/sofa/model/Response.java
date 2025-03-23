package com.luman.sofa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 响应
 *
 * @author yeyinghao
 * @date 2024/03/29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Response extends DTO {

	/**
	 * 串口版本uid
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * http响应状态
	 */
	private Integer code;

	/**
	 * 成功
	 */
	private boolean success;

	/**
	 * 错误代码
	 */
	private String errCode;

	/**
	 * 错误消息
	 */
	private String errMessage;

	/**
	 * 请求id
	 */
	private String traceId;

	/**
	 * 请求时间戳
	 */
	private Long timestamp;

}
