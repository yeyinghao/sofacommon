package com.luman.sofa.common.helper;

import cn.hutool.core.util.StrUtil;
import com.luman.sofa.common.enums.ErrorEnum;
import com.luman.sofa.common.utils.TracerUtil;
import com.luman.sofa.model.MutilResponse;
import com.luman.sofa.model.PageResponse;
import com.luman.sofa.model.Response;
import com.luman.sofa.model.SingleResponse;
import com.luman.sofa.model.enums.ByErrorCode;

import java.util.List;

public class ResponseHelper {

	/**
	 * 成功
	 *
	 * @return {@link Response }
	 */
	public static Response success() {
		Response response = buildResp(ErrorEnum.SUCCESS);
		response.setSuccess(Boolean.TRUE);
		return response;
	}

	/**
	 * 成功
	 *
	 * @return {@link Response }
	 */
	public static <T> SingleResponse<T> singleSuccess(T data) {
		SingleResponse<T> response = (SingleResponse<T>) buildResp(ErrorEnum.SUCCESS);
		response.setSuccess(Boolean.TRUE);
		response.setData(data);
		return response;
	}

	/**
	 * 成功
	 *
	 * @return {@link Response }
	 */
	public static <T> MutilResponse<T> mutilSuccess(List<T> data) {
		MutilResponse<T> response = (MutilResponse<T>) buildResp(ErrorEnum.SUCCESS);
		response.setSuccess(Boolean.TRUE);
		response.setData(data);
		return response;
	}

	/**
	 * 成功
	 *
	 * @return {@link Response }
	 */
	public static <T> PageResponse<T> pageSuccess(List<T> data) {
		PageResponse<T> response = (PageResponse<T>) buildResp(ErrorEnum.SUCCESS);
		response.setSuccess(Boolean.TRUE);
		response.setData(data);
		return response;
	}

	private static Response buildResp(ByErrorCode errorCode) {
		Response resp = new Response();
		resp.setCode(errorCode.getHttpCode());
		resp.setErrCode(errorCode.getCode());
		resp.setErrMessage(errorCode.getDesc());
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
	public static Response fail(ByErrorCode byErrorCode, String message) {
		Response response = buildResp(byErrorCode);
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
	public static Response fail(ByErrorCode byErrorCode) {
		Response response = buildResp(byErrorCode);
		response.setSuccess(Boolean.FALSE);
		return response;
	}

}
