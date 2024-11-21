/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.sofa.bootstrap.config;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;


/**
 * 上传配置
 *
 * @author yeyinghao
 * @date 2023/12/11
 */
@Configuration
public class MultipartConfig {

	/**
	 * 文件上传配置
	 *
	 * @return {@link MultipartConfigElement}
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 文件最大10M,DataUnit提供5中类型B,KB,MB,GB,TB
		factory.setMaxFileSize(DataSize.ofGigabytes(1L));
		/// 设置总上传数据总大小10M
		factory.setMaxRequestSize(DataSize.ofGigabytes(1L));
		return factory.createMultipartConfig();
	}
}
