package com.luman.sofa.common.utils;

import cn.hutool.core.util.StrUtil;
import com.alipay.common.tracer.core.generator.TraceIdGenerator;
import com.alipay.common.tracer.core.utils.TracerUtils;
import com.luman.sofa.common.constant.CommConstant;
import lombok.experimental.UtilityClass;
import org.slf4j.MDC;

@UtilityClass
public class TracerUtil {

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
		String traceId = TracerUtils.getTraceId();
		if (StrUtil.isBlank(traceId)) {
			traceId = TraceIdGenerator.generate();
		}
		MDC.put(CommConstant.TRACE_ID, traceId);
	}

}
