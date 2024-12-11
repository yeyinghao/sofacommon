/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.sofa.common.satoken.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForStateless;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SaToken的配置类
 *
 * @author yeyinghao
 * @date 2024/02/28
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

	/**
	 * 获取stp逻辑jwt
	 *
	 * @return {@link StpLogic}
	 */
	@Bean
	public StpLogic getStpLogicJwt() {
		return new StpLogicJwtForStateless();
	}

	/**
	 * 添加拦截器
	 *
	 * @param registry 注册表
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin()))
				.addPathPatterns("/**")
				.excludePathPatterns("/favicon.ico", "/", "/**/open/**");
	}
}
