package com.luman.sofa.common.satoken.handler;


import cn.dev33.satoken.exception.NotLoginException;
import com.luman.sofa.common.enums.ErrorEnum;
import com.luman.sofa.common.helper.ResponseHelper;
import com.luman.sofa.common.utils.LoggerUtil;
import com.luman.sofa.dto.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理程序
 *
 * @author yeyinghao
 * @date 2023/08/01
 */
@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class SaTokenExceptionHandler {

	/**
	 * sa-token-未登录异常
	 *
	 * @param e e
	 */
	@ExceptionHandler(NotLoginException.class)
	public Response<Void> notLoginExceptionHandler(NotLoginException e) {
		LoggerUtil.info(log, e.getMessage());
		return ResponseHelper.fail(ErrorEnum.FORBIDDEN, "禁止访问");
	}

}
