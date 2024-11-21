package com.luman.sofa.cache.integration.config;

import cn.hutool.core.map.MapUtil;
import com.luman.sofa.common.constant.CommConstant;
import com.luman.sofa.common.utils.LoggerUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * redisson配置
 *
 * @author yeyinghao
 * @date 2023/09/16
 */
@Component
@EnableCaching
@Data
@ConfigurationProperties(prefix = "smy.cache")
@Slf4j
public class CacheConfig {

	/**
	 * 项目key前缀
	 */
	private String projectKeyPrefix;

	/**
	 * 缓存key前缀
	 */
	private String cacheKeyPrefix;

	/**
	 * TTL毫秒
	 */
	private Long ttlMillSecond;

	/**
	 * 最大空闲时间毫秒
	 */
	private Long maxIdleTimeMillSecond;

	/**
	 * 默认过期秒
	 */
	private Long defaultExpiredSecond;

	/**
	 * 缓存管理器
	 *
	 * @param redissonClient redisson客户
	 * @return {@link CacheManager}
	 */
	@Bean
	public CacheManager cacheManager(RedissonClient redissonClient) {
		try {
			Map<String, org.redisson.spring.cache.CacheConfig> config = MapUtil.newHashMap();
			// 创建一个名称为"testMap"的缓存，过期时间ttl为24分钟，同时最长空闲时maxIdleTime为12分钟。
			org.redisson.spring.cache.CacheConfig cacheConfig = new org.redisson.spring.cache.CacheConfig(ttlMillSecond, maxIdleTimeMillSecond);
			config.put(getRealKey(cacheKeyPrefix), cacheConfig);
			return new RedissonSpringCacheManager(redissonClient, config);
		} catch (Throwable e) {
			LoggerUtil.error(log, e);
		}
		return null;
	}

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
