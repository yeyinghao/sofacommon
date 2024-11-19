package com.luman.sofa.dto;

import java.io.Serial;

/**
 * 响应
 *
 * @author yeyinghao
 * @date 2024/03/29
 */
public class Response<T> extends DTO {

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
	 * 数据
	 */
	private T data;

	/**
	 * 请求id
	 */
	private String traceId;

	/**
	 * 请求时间戳
	 */
	private Long timestamp;

	/**
	 * 获取code
	 *
	 * @return {@link Integer }
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return boolean
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * 获取errcode
	 *
	 * @return {@link String }
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * @param errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * 获取errmessage
	 *
	 * @return {@link String }
	 */
	public String getErrMessage() {
		return errMessage;
	}

	/**
	 * @param errMessage
	 */
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	/**
	 * 获取data
	 *
	 * @return {@link T }
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 获取traceid
	 *
	 * @return {@link String }
	 */
	public String getTraceId() {
		return traceId;
	}

	/**
	 * settraceid
	 *
	 * @param traceId traceid
	 */
	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	/**
	 * 获取timestamp
	 *
	 * @return {@link Long }
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
