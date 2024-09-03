/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.7
 */

package com.luman.sofasmy.util.util;

import cn.hutool.core.util.StrUtil;
import com.luman.sofasmy.util.exception.BizException;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;


/**
 * 日志记录器工具类
 *
 * @author yeyinghao
 * @date 2023/08/01
 */
@UtilityClass
@SuppressWarnings("unused")
public class LoggerUtil {

	/**
	 * 警告
	 *
	 * @param logger  日志记录器
	 * @param e       e
	 * @param message 消息
	 */
	public static void warn(Logger logger, Throwable e, String message) {
		logger.warn(message, e);
	}

	/**
	 * 警告
	 *
	 * @param logger   日志记录器
	 * @param e        e
	 * @param template 模板
	 * @param messages 消息
	 */
	public static void warn(Logger logger, Throwable e, String template, Object... messages) {
		logger.warn(StrUtil.format(template, messages), e);
	}

	/**
	 * 警告
	 *
	 * @param logger  日志记录器
	 * @param message 消息
	 */
	public static void warn(Logger logger, String message) {
		logger.warn(message);
	}

	/**
	 * 警告
	 *
	 * @param logger   日志记录器
	 * @param template 模板
	 * @param messages 消息
	 */
	public static void warn(Logger logger, String template, Object... messages) {
		logger.warn(StrUtil.format(template, messages));
	}

	/**
	 * 调试
	 *
	 * @param logger  日志记录器
	 * @param message 消息
	 */
	public static void debug(Logger logger, String message) {
		logger.debug(message);
	}

	/**
	 * 调试
	 *
	 * @param logger   日志记录器
	 * @param template 模板
	 * @param messages 消息
	 */
	public static void debug(Logger logger, String template, Object... messages) {
		logger.debug(StrUtil.format(template, messages));
	}

	/**
	 * 信息
	 *
	 * @param logger  日志记录器
	 * @param e       e
	 * @param message 消息
	 */
	public static void info(Logger logger, Throwable e, String message) {
		logger.info(message, e);
	}

	/**
	 * 信息
	 *
	 * @param logger 日志记录器
	 * @param e      e
	 */
	public static void info(Logger logger, Throwable e) {
		logger.info(e.getMessage(), e);
	}

	/**
	 * 信息
	 *
	 * @param logger   日志记录器
	 * @param e        e
	 * @param template 模板
	 * @param messages 消息
	 */
	public static void info(Logger logger, Throwable e, String template, Object... messages) {
		logger.info(StrUtil.format(template, messages), e);
	}

	/**
	 * 信息
	 *
	 * @param logger  日志记录器
	 * @param message 消息
	 */
	public static void info(Logger logger, String message) {
		logger.info(message);
	}

	/**
	 * 信息
	 *
	 * @param logger   日志记录器
	 * @param template 模板
	 * @param messages 消息
	 */
	public static void info(Logger logger, String template, Object... messages) {
		logger.info(StrUtil.format(template, messages));
	}

	/**
	 * 错误
	 *
	 * @param logger  日志记录器
	 * @param e       e
	 * @param message 消息
	 */
	public static void error(Logger logger, Throwable e, String message) {
		logger.error(message, e);
	}

	/**
	 * 错误
	 *
	 * @param logger 日志记录器
	 * @param e      e
	 */
	public static void error(Logger logger, Throwable e) {
		logger.error(e.getMessage(), e);
	}

	/**
	 * 错误
	 *
	 * @param logger   日志记录器
	 * @param e        e
	 * @param template 模板
	 * @param messages 消息
	 */
	public static void error(Logger logger, Throwable e, String template, Object... messages) {
		logger.error(StrUtil.format(template, messages), e);
	}

	/**
	 * 错误
	 *
	 * @param logger  日志记录器
	 * @param message 消息
	 */
	public static void error(Logger logger, String message) {
		logger.error(message);
	}

	/**
	 * 错误
	 *
	 * @param logger   日志记录器
	 * @param template 模板
	 * @param messages 消息
	 */
	public static void error(Logger logger, String template, Object... messages) {
		logger.error(StrUtil.format(template, messages));
	}

	/**
	 * 信息
	 *
	 * @param logger 日志记录器
	 * @param e      e
	 */
	public static void info(Logger logger, BizException e) {
		logger.info(e.toString());
	}
}
