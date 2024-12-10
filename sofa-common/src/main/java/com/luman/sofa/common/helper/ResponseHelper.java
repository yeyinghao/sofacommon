package com.luman.sofa.common.helper;

import cn.hutool.core.util.StrUtil;
import com.luman.sofa.common.enums.ErrorEnum;
import com.luman.sofa.common.utils.TracerUtil;
import com.luman.sofa.dto.Response;
import com.luman.sofa.dto.enums.ByErrorCode;

public class ResponseHelper {

	/**
	 * 成功
	 *
	 * @return {@link Response }
	 */
	public static <T> Response<T> success(T data) {
		Response<T> response = buildResp(ErrorEnum.SUCCESS);
		response.setSuccess(Boolean.TRUE);
		response.setData(data);
		return response;
	}

	private static <T> Response<T> buildResp(ByErrorCode byErrorCode) {
		Response<T> resp = new Response<>();
		resp.setCode(byErrorCode.getHttpCode());
		resp.setErrCode(byErrorCode.getCode());
		resp.setErrMessage(byErrorCode.getDesc());
		resp.setTimestamp(System.currentTimeMillis());
		resp.setTraceId(TracerUtil.getThreadTraceId());
		return resp;
	}

	/**
	 * 失败
	 *
	 * @param byErrorCode 错误枚举
	 * @param message     子的错误消息
	 * @return {@link Response }
	 */
	public static <T> Response<T> fail(ByErrorCode byErrorCode, String message) {
		Response<T> response = buildResp(byErrorCode);
		response.setSuccess(Boolean.FALSE);
		StringBuilder msg = new StringBuilder();
		if (StrUtil.isNotBlank(message)) {
			msg.append(message);
		}
		response.setErrCode(byErrorCode.getCode());
		if (StrUtil.isNotBlank(msg.toString())) {
			response.setErrMessage(msg.toString());
		}
		return response;
	}

	/**
	 * 失败
	 *
	 * @param byErrorCode 错误枚举
	 * @return {@link Response }
	 */
	public static <T> Response<T> fail(ByErrorCode byErrorCode) {
		Response<T> response = buildResp(byErrorCode );
		response.setSuccess(Boolean.FALSE);
		return response;
	}

}
