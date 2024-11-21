package com.luman.sofa.bootstrap.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 * 应用程序配置
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
@Data
@Configuration
public class AppConfig {

	/**
	 * 应用程序名称
	 */
	@Value("${spring.application.name}")
	private String applicationName;

}
