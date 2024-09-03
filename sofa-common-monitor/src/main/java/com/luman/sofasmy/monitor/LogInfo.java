package com.luman.sofasmy.monitor;

import lombok.Data;
import org.slf4j.Logger;

import java.util.List;

/**
 * 日志信息
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
@Data
public class LogInfo {

	/**
	 * 日志
	 */
	private Logger log;

	/**
	 * 执行结果
	 */
	private Boolean res;

	/**
	 * 开始时间
	 */
	private Long startTime;

	/**
	 * 类名称
	 */
	private String className;

	/**
	 * 方法名称
	 */
	private String methodName;

	/**
	 * 入参
	 */
	private List<Object> args;

	/**
	 * 出参
	 */
	private Object response;

	/**
	 * throwable
	 */
	private Throwable throwable;

}
