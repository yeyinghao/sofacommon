package com.luman.sofa.cache.integration.config;

import com.luman.sofa.common.constant.CommConstant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;


/**
 * redisson配置
 *
 * @author yeyinghao
 * @date 2023/09/16
 */
@ConfigurationProperties(prefix = "smy.cache")
@Component
@EnableCaching
@Data
@Slf4j
public class CacheConfig {

	/**
	 * 项目key前缀
	 */
	private String projectKeyPrefix;

	/**
	 * 默认过期秒
	 */
	private Long defaultExpiredSecond;

	/**
	 * 获取真正key
	 *
	 * @param key key
	 * @return {@link String}
	 */
	public String getRealKey(String key) {
		return projectKeyPrefix + CommConstant.UNDERLINE + key;
	}

	/**
	 * 获取过期
	 *
	 * @param expired 过期
	 * @return long
	 */
	public long getExpired(long expired) {
		return expired <= 0 ? defaultExpiredSecond : expired;
	}
}
