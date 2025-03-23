package com.luman.sofa.bootstrap.handler;

import com.luman.sofa.common.enums.ErrorEnum;
import com.luman.sofa.common.exception.BizException;
import com.luman.sofa.common.helper.ResponseHelper;
import com.luman.sofa.common.utils.LoggerUtil;
import com.luman.sofa.model.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理程序
 *
 * @author yeyinghao
 * @date 2023/08/01
 */
@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {

	/**
	 * 请求
	 */
	private final HttpServletRequest request;

	/**
	 * 拦截Exception异常
	 */
	@ExceptionHandler(Exception.class)
	public Response exceptionHandler(Exception e) {
		LoggerUtil.error(log, e);
		return ResponseHelper.fail(ErrorEnum.SYS_ERROR);
	}

	/**
	 * 拦截NoHandlerFoundException异常
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public Response noHandlerFoundException(NoHandlerFoundException e) {
		LoggerUtil.info(log, e, request.getServletPath());
		return ResponseHelper.fail(ErrorEnum.NOT_FOUND, "请求路径找不到");
	}

	/**
	 * 拦截HttpRequestMethodNotSupportedException异常
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Response httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		LoggerUtil.info(log, e, request.getServletPath());
		return ResponseHelper.fail(ErrorEnum.BIZ_ERROR, "请求方式不支持");
	}

	/**
	 * 拦截 bizException异常
	 */
	@ExceptionHandler(BizException.class)
	public Response bizExceptionHandler(BizException e) {
		LoggerUtil.info(log, e);
		return ResponseHelper.fail(e.getByErrorCode(), e.getMessage());
	}

}
