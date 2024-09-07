package com.luman.sofa.common.dto;

import cn.hutool.core.util.StrUtil;
import com.alipay.common.tracer.core.utils.TracerUtils;
import com.luman.sofa.common.enums.ByErrorCode;
import com.luman.sofa.common.enums.ErrorEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * 响应
 *
 * @author yeyinghao
 * @date 2024/03/29
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
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
	private String traceId = TracerUtils.getTraceId();

	/**
	 * 请求时间戳
	 */
	private Long timestamp = System.currentTimeMillis();

	/**
	 * 成功
	 *
	 * @return {@link Response }
	 */
	public static <T> Response<T> success(T data) {
		Response<T> response = new Response<>();
		response.setCode(ErrorEnum.SUCCESS.getHttpCode());
		response.setSuccess(Boolean.TRUE);
		response.setData(data);
		return response;
	}

	/**
	 * 失败
	 *
	 * @param byErrorCode 错误枚举
	 * @param message   子的错误消息
	 * @return {@link Response }
	 */
	public static <T> Response<T> fail(ByErrorCode byErrorCode, String message) {
		Response<T> response = new Response<>();
		response.setCode(byErrorCode.getHttpCode());
		response.setSuccess(Boolean.FALSE);
		StringBuilder msg = new StringBuilder();
		if (StrUtil.isNotBlank(message)) {
			msg.append(message);
		}
		response.setErrCode(byErrorCode.getCode());
		response.setErrMessage(msg.toString());
		return response;
	}

	/**
	 * 失败
	 *
	 * @param byErrorCode 错误枚举
	 * @return {@link Response }
	 */
	public static <T> Response<T> fail(ByErrorCode byErrorCode) {
		Response<T> response = new Response<>();
		response.setCode(byErrorCode.getHttpCode());
		response.setSuccess(Boolean.FALSE);
		response.setErrCode(byErrorCode.getCode());
		response.setErrMessage(byErrorCode.getDesc());
		return response;
	}

}
