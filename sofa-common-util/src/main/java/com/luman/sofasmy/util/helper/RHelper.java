package com.luman.sofasmy.util.helper;

import cn.hutool.core.util.StrUtil;
import com.luman.sofasmy.dto.Response;
import com.luman.sofasmy.util.enums.ByErrorCode;
import com.luman.sofasmy.util.enums.ErrorEnum;
import com.luman.sofasmy.util.util.TraceIdUtil;
import lombok.experimental.UtilityClass;

/**
 * 响应
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
@UtilityClass
public class RHelper {

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
		response.setTraceId(TraceIdUtil.getThreadTraceId());
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
		response.setTraceId(TraceIdUtil.getThreadTraceId());
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
		response.setTraceId(TraceIdUtil.getThreadTraceId());
		return response;
	}

}
