package com.luman.sofa.common.monitor.log;

import cn.hutool.json.JSONUtil;
import com.luman.sofa.common.monitor.LogAspect;
import com.luman.sofa.common.monitor.LogInfo;
import com.luman.sofa.common.exception.BizException;
import com.luman.sofa.common.utils.LoggerUtil;
import com.luman.sofa.common.utils.TimeUtil;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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
		try {
			Logged log = getAnnotation(joinPoint, Logged.class);
			logInfo = buildLogInfo(joinPoint, log.topic());
			Object resp = joinPoint.proceed();
			logInfo.setResponse(resp);
			logInfo.setRes(true);
			return resp;
		} catch (BizException e) {
			logInfo.setRes(!e.isError());
			throw e;
		} finally {
			printLog(logInfo);
		}
	}

	@Override
	public void printLog(LogInfo logInfo) {
		LoggerUtil.info(logInfo.getLog(), LOG_TEMPLATE, logInfo.getRes(), TimeUtil.getCostTime(logInfo.getStartTime()), logInfo.getClassName(), logInfo.getMethodName(), JSONUtil.toJsonStr(logInfo.getArgs()), JSONUtil.toJsonStr(logInfo.getResponse()));
	}
}