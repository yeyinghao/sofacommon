/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.7
 */

package com.luman.sofasmy.util.util;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.luman.sofasmy.util.constant.CommConstant;
import lombok.experimental.UtilityClass;
import org.slf4j.MDC;

/**
 * 跟踪id工具类
 *
 * @author yeyinghao
 * @date 2023/08/01
 */
@UtilityClass
public class TraceIdUtil {

	/**
	 * 获取线程跟踪id
	 *
	 * @return traceId
	 */
	public static String getThreadTraceId() {
		// 如果不存在traceId 则生成
		if (StrUtil.isBlank(MDC.get(CommConstant.TRACE_ID))) {
			genThreadTraceId();
		}
		return MDC.get(CommConstant.TRACE_ID);
	}

	/**
	 * clear线traceid
	 */
	public static void clearThreadTraceId() {
		MDC.clear();
	}

	/**
	 * 生成traceId
	 */
	private static void genThreadTraceId() {
		MDC.put(CommConstant.TRACE_ID, IdUtil.simpleUUID());
	}
}
