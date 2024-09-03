package com.luman.sofasmy.monitor.log;

import cn.hutool.json.JSONUtil;
import com.luman.sofasmy.util.exception.BizException;
import com.luman.sofasmy.util.util.LoggerUtil;
import com.luman.sofasmy.util.util.TimeUtil;
import com.luman.sofasmy.monitor.LogAspect;
import com.luman.sofasmy.monitor.LogInfo;
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

	/**
	 * <a href="https://blog.csdn.net/zhengchao1991/article/details/53391244">The syntax of pointcut </a>
	 */
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
