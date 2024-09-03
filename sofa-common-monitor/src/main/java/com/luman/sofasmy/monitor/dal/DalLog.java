package com.luman.sofasmy.monitor.dal;


import com.luman.sofasmy.util.constant.LoggerConstant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库日志
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DalLog {

	/**
	 * 主题
	 *
	 * @return {@link String }
	 */
	String topic() default LoggerConstant.DAL_LOG;

}
