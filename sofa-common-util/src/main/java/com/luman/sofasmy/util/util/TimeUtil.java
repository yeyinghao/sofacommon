package com.luman.sofasmy.util.util;

import lombok.experimental.UtilityClass;

/**
 * 时间工具类
 *
 * @author yeyinghao
 * @date 2024/08/02
 */
@UtilityClass
public class TimeUtil {

	/**
	 * 获取调用消耗时间
	 *
	 * @param startTime 开始时间
	 * @return long
	 */
	public static long getCostTime(long startTime) {
		return System.currentTimeMillis() - startTime;
	}
}
