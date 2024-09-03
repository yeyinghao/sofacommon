package com.luman.sofasmy.dto;

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

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	@Override
	public String toString() {
		return "Response{" +
				"code=" + code +
				", success=" + success +
				", errCode='" + errCode + '\'' +
				", errMessage='" + errMessage + '\'' +
				", data=" + data +
				", traceId='" + traceId + '\'' +
				'}';
	}
}
