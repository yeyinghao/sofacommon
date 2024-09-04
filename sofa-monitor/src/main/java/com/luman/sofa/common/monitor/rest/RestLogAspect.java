package com.luman.sofa.common.monitor.rest;

import cn.hutool.extra.validation.BeanValidationResult;
import cn.hutool.extra.validation.ValidationUtil;
import cn.hutool.json.JSONUtil;
import com.luman.sofa.common.dto.DTO;
import com.luman.sofa.common.monitor.LogAspect;
import com.luman.sofa.common.monitor.LogInfo;
import com.luman.sofa.common.constant.CommConstant;
import com.luman.sofa.common.enums.ErrorEnum;
import com.luman.sofa.common.exception.BizException;
import com.luman.sofa.common.exception.CheckUtil;
import com.luman.sofa.common.helper.RHelper;
import com.luman.sofa.common.utils.LoggerUtil;
import com.luman.sofa.common.utils.TimeUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Aspect
@Slf4j
public class RestLogAspect extends LogAspect {

	private final static String LOG_TEMPLATE = "result={}, cost={}ms, target={}#{}, request={}, response={}";

	@Pointcut("@within(RestLog) && execution(public * *(..))")
	public void pointcut() {
	}

	@Around(value = "pointcut()")
	@SneakyThrows
	public Object proceed(ProceedingJoinPoint joinPoint) {
		LogInfo logInfo = new LogInfo();
		Object resp = null;
		try {
			RestLog log = getAnnotation(joinPoint, RestLog.class);
			logInfo = buildLogInfo(joinPoint, log.topic());
			Object[] args = joinPoint.getArgs();
			for (Object arg : args) {
				if (arg instanceof DTO) {
					preCheck((DTO) arg);
				}
			}
			resp = joinPoint.proceed();
			logInfo.setRes(true);
			return resp;
		} catch (BizException e) {
			LoggerUtil.info(log, e);
			logInfo.setRes(!e.isError());
			resp = RHelper.fail(e.getByErrorCode(), e.getMessage());
		} catch (Throwable e) {
			LoggerUtil.error(log, e);
			resp = RHelper.fail(ErrorEnum.SYS_ERROR);
		} finally {
			logInfo.setResponse(resp);
			printLog(logInfo);
		}
		return resp;
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
		CheckUtil.isTrue(result.isSuccess(), ErrorEnum.ILLEGAL_PARAMETER, result.getErrorMessages().stream().map(item -> item.getPropertyName() + CommConstant.COLON + item.getMessage()).collect(Collectors.joining(CommConstant.SEMICOLON)));
	}
}
