package com.luman.sofasmy.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Objects;

/**
 * 日志切面
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
public abstract class LogAspect {

	/**
	 * 获取指定的注解信息
	 *
	 * @param joinPoint 连接点
	 * @param t         t
	 * @return {@link T }
	 */
	public <T extends Annotation> T getAnnotation(ProceedingJoinPoint joinPoint, Class<T> t) {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		T annotation = methodSignature.getMethod().getAnnotation(t);
		// 如果方法有注解取方法的, 没有则使用类上的注解
		if (Objects.nonNull(annotation)) {
			return annotation;
		}
		return joinPoint.getTarget().getClass().getAnnotation(t);
	}


	/**
	 * 构建日志信息
	 *
	 * @param joinPoint 连接点
	 * @return {@link LogInfo }
	 */
	public LogInfo buildLogInfo(ProceedingJoinPoint joinPoint, String log) {
		LogInfo logInfo = new LogInfo();
		logInfo.setLog(LoggerFactory.getLogger(log));
		logInfo.setRes(false);
		logInfo.setStartTime(System.currentTimeMillis());
		logInfo.setClassName(AopUtils.getTargetClass(joinPoint.getTarget()).getSimpleName());
		logInfo.setMethodName(joinPoint.getSignature().getName());
		logInfo.setArgs(List.of(joinPoint.getArgs()));
		return logInfo;
	}

	/**
	 * 打印日志
	 *
	 * @param logInfo 日志信息
	 */
	public abstract void printLog(LogInfo logInfo);
}
