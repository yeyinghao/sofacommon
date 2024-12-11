package com.luman.sofa.common.log;


import com.luman.sofa.common.constant.LoggerConstant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Logged {

	boolean valid() default false;

	boolean web() default false;

	/**
	 * 主题
	 *
	 * @return {@link String }
	 */
	String topic() default LoggerConstant.BIZ_LOG;

}
