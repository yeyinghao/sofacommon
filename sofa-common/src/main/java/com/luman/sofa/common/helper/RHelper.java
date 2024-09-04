package com.luman.sofa.common.helper;

import cn.hutool.core.util.StrUtil;
import com.luman.sofa.common.dto.Response;
import com.luman.sofa.common.enums.ErrorEnum;
import com.luman.sofa.common.enums.ByErrorCode;
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
