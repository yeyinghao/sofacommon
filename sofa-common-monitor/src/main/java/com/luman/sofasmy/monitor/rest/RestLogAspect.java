package com.luman.sofasmy.monitor.rest;

import cn.hutool.extra.validation.BeanValidationResult;
import cn.hutool.extra.validation.ValidationUtil;
import cn.hutool.json.JSONUtil;
import com.luman.sofasmy.dto.DTO;
import com.luman.sofasmy.monitor.LogAspect;
import com.luman.sofasmy.monitor.LogInfo;
import com.luman.sofasmy.util.constant.CommConstant;
import com.luman.sofasmy.util.enums.ErrorEnum;
import com.luman.sofasmy.util.exception.BizException;
import com.luman.sofasmy.util.exception.CheckUtil;
import com.luman.sofasmy.util.helper.RHelper;
import com.luman.sofasmy.util.util.LoggerUtil;
import com.luman.sofasmy.util.util.TimeUtil;
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

	/**
	 * <a href="https://blog.csdn.net/zhengchao1991/article/details/53391244">The syntax of pointcut </a>
	 */
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
