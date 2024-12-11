package com.luman.sofa.common.log;

import cn.hutool.extra.validation.BeanValidationResult;
import cn.hutool.extra.validation.ValidationUtil;
import cn.hutool.json.JSONUtil;
import com.luman.sofa.common.constant.CommConstant;
import com.luman.sofa.common.enums.ErrorEnum;
import com.luman.sofa.common.exception.BizException;
import com.luman.sofa.common.exception.VarChecker;
import com.luman.sofa.common.helper.ResponseHelper;
import com.luman.sofa.common.utils.LoggerUtil;
import com.luman.sofa.common.utils.TimeUtil;
import com.luman.sofa.dto.DTO;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 日志切面
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
@Component
@Aspect
public class LoggedAspect extends LogAspect {

	private final static String LOG_TEMPLATE = "result={}, cost={}ms, className={}, methodName={}, request={}, response={}";

	@Pointcut("@within(Logged) && execution(public * *(..))")
	public void pointcut() {
	}

	@Around(value = "pointcut()")
	@SneakyThrows
	public Object proceed(ProceedingJoinPoint joinPoint) {
		LogInfo logInfo = new LogInfo();
		boolean web = false;
		boolean valid = false;
		try {
			Logged log = getAnnotation(joinPoint, Logged.class);
			logInfo = buildLogInfo(joinPoint, log.topic());
			valid = log.valid();
			web = log.web();
			if (valid) {
				checkParam(joinPoint.getArgs());
			}
			Object resp = joinPoint.proceed();
			logInfo.setResponse(resp);
			logInfo.setRes(true);
			return resp;
		} catch (BizException e) {
			logInfo.setRes(!e.isError());
			if (web) {
				LoggerUtil.info(logInfo.getLog(), e);
				return ResponseHelper.fail(e.getByErrorCode(), e.getMessage());
			} else {
				throw e;
			}
		} catch (Throwable e) {
			if (web) {
				LoggerUtil.info(logInfo.getLog(), e);
				return ResponseHelper.fail(ErrorEnum.SYS_ERROR);
			} else {
				throw e;
			}
		} finally {
			printLog(logInfo);
		}
	}

	private void checkParam(Object[] args) {
		for (Object arg : args) {
			if (arg instanceof DTO) {
				preCheck((DTO) arg);
			}
		}
	}

	@Override
	public void printLog(LogInfo logInfo) {
		LoggerUtil.info(logInfo.getLog(), LOG_TEMPLATE, logInfo.getRes(), TimeUtil.getCostTime(logInfo.getStartTime()), logInfo.getClassName(), logInfo.getMethodName(), JSONUtil.toJsonStr(logInfo.getArgs()), JSONUtil.toJsonStr(logInfo.getResponse()));
	}

	/**
	 * validate校验
	 *
	 * @param request 请求
	 */
	private static void preCheck(DTO request) {
		if (Objects.isNull(request)) {
			return;
		}
		// 获取校验结果
		BeanValidationResult result = ValidationUtil.warpValidate(request);
		// 校验失败 抛错误
		VarChecker.isTrue(result.isSuccess(), ErrorEnum.ILLEGAL_PARAMETER, result.getErrorMessages().stream().map(item -> item.getPropertyName() + CommConstant.COLON + item.getMessage()).collect(Collectors.joining(CommConstant.SEMICOLON)));
	}
}
