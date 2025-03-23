/*
 * QQ: 1113531030 WX: missyeyh Phone: 17689397484 Copyright (c) Ye Yinghao 2022.1 - 2023.2
 */

package com.luman.sofa.bootstrap.handler;

import com.luman.sofa.common.enums.ErrorEnum;
import com.luman.sofa.common.exception.VarChecker;
import com.luman.sofa.model.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * http状态代码增强
 *
 * @author yeyinghao
 * @date 2023/08/01
 */
@SuppressWarnings({"NullableProblems", "rawtypes"})
@ControllerAdvice
public class HttpStatusCodeAdvice implements ResponseBodyAdvice {

	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return returnType.getParameterType().isAssignableFrom(Response.class);
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
	                              Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		if (body instanceof Response) {
			Integer status = ((Response) body).getCode();
			HttpStatus httpStatus = HttpStatus.resolve(status);
			VarChecker.notNull(httpStatus, ErrorEnum.SYS_ERROR);
			response.setStatusCode(httpStatus);
		}
		return body;
	}
}
