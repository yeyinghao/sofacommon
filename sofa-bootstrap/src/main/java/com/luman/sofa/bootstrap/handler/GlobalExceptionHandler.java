package com.luman.sofa.bootstrap.handler;

import cn.hutool.core.util.StrUtil;
import com.luman.sofa.common.constant.CommConstant;
import com.luman.sofa.common.enums.ErrorEnum;
import com.luman.sofa.common.exception.BizException;
import com.luman.sofa.common.helper.ResponseHelper;
import com.luman.sofa.common.utils.LoggerUtil;
import com.luman.sofa.dto.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
	public Response<String> exceptionHandler(Exception e) {
		LoggerUtil.error(log, e);
		return ResponseHelper.fail(ErrorEnum.SYS_ERROR);
	}

	/**
	 * 拦截NoHandlerFoundException异常
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public Response<String> sqlExceptionHandler(NoHandlerFoundException e) {
		LoggerUtil.info(log, e, request.getServletPath());
		return ResponseHelper.fail(ErrorEnum.NOT_FOUND);
	}

	/**
	 * 拦截HttpRequestMethodNotSupportedException异常
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Response<String> sqlExceptionHandler(HttpRequestMethodNotSupportedException e) {
		LoggerUtil.info(log, e, request.getServletPath());
		return ResponseHelper.fail(ErrorEnum.BIZ_ERROR, "请求方式不支持");
	}

	/**
	 * 拦截 bizException异常
	 */
	@ExceptionHandler(BizException.class)
	public Response<String> bizExceptionHandler(BizException e) {
		LoggerUtil.info(log, e);
		return ResponseHelper.fail(e.getByErrorCode(), e.getMessage());
	}

	/**
	 * 绑定异常
	 *
	 * @param e e
	 * @return {@link Response}<{@link String}>
	 */
	@ExceptionHandler(BindException.class)
	public Response<String> bindExceptionHandler(BindException e) {
		LoggerUtil.info(log, e);
		// 拿到@NotNull,@NotBlank和 @NotEmpty等注解上的message值
		String msg = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
		if (StrUtil.isNotEmpty(msg)) {
			// 自定义状态返回
			return ResponseHelper.fail(ErrorEnum.ILLEGAL_PARAMETER, msg);
		}
		// 参数类型不匹配检验
		StringBuilder message = new StringBuilder();
		List<FieldError> fieldErrors = e.getFieldErrors();
		fieldErrors.forEach((item) -> message.append("参数:[").append(item.getObjectName())
				.append(".").append(item.getField()).append("]的传入值:[")
				.append(item.getRejectedValue()).append("]与预期的字段类型不匹配."));
		return ResponseHelper.fail(ErrorEnum.ILLEGAL_PARAMETER, message.toString());
	}

	/**
	 * 约束违反例外
	 *
	 * @param e e
	 * @return {@link Response}<{@link String}>
	 */
	@ExceptionHandler(value = ConstraintViolationException.class)
	public Response<String> constraintViolationExceptionHandler(ConstraintViolationException e) {
		LoggerUtil.info(log, e);
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		String message = violations.stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.joining(";"));
		return ResponseHelper.fail(ErrorEnum.ILLEGAL_PARAMETER, message);
	}

	/**
	 * 方法参数无效例外
	 *
	 * @param e e
	 * @return {@link Response}<{@link String}>
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Response<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		LoggerUtil.info(log, e);
		String message = e.getBindingResult().getFieldErrors().stream()
				.map(item -> item.getField() + CommConstant.COLON + item.getDefaultMessage())
				.collect(Collectors.joining(CommConstant.SEMICOLON));
		return ResponseHelper.fail(ErrorEnum.ILLEGAL_PARAMETER, message);
	}
}
