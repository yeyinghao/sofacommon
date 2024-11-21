/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.10
 */

package com.luman.sofa.cache.integration.impl;

import com.luman.sofa.cache.integration.CacheClient;
import com.luman.sofa.cache.integration.config.CacheConfig;
import com.luman.sofa.common.constant.LoggerConstant;
import com.luman.sofa.common.monitor.log.Logged;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.redisson.api.*;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * 缓存服务实现
 *
 * @author yeyinghao
 * @date 2024/04/04
 */
@Service
@RequiredArgsConstructor
@Logged(topic = LoggerConstant.CACHE_LOG)
public class CacheClientImpl implements CacheClient {

	/**
	 * redisson client对象
	 */
	private final RedissonClient redissonClient;

	/**
	 * redisson配置
	 */
	private final CacheConfig redissonConfig;

	@Override
	public <T> T get(String key) {
		RBucket<T> bucket = redissonClient.getBucket(key);
		return bucket.get();
	}

	@Override
	public <T> void save(String key, T value) {
		redissonClient.getBucket(key).set(value);
	}

	@Override
	public <T> void saveExpire(String key, T value, long expired) {
		redissonClient.getBucket(key).set(value, Duration.ofSeconds(redissonConfig.getExpired(expired)));
	}

	@Override
	public <T> boolean trySave(String key, T value) {
		return redissonClient.getBucket(key).setIfAbsent(value);
	}

	@Override
	public <T> boolean trySaveExpire(String key, T value, long expired) {
		return redissonClient.getBucket(key).setIfAbsent(value, Duration.ofSeconds(redissonConfig.getExpired(expired)));
	}

	@Override
	public void delete(String key) {
		redissonClient.getBucket(key).delete();
	}

	@Override
	public boolean isExists(String key) {
		return redissonClient.getBucket(key).isExists();
	}

	@Override
	public <T> RList<T> getList(String key) {
		return redissonClient.getList(key);
	}

	@Override
	public <K, V> RMapCache<K, V> getMapCache(String key) {
		return redissonClient.getMapCache(key);
	}

	@Override
	public <K, V> RMap<K, V> getMap(String key) {
		return redissonClient.getMap(key);
	}

	@Override
	public <T> RSet<T> getSet(String key) {
		return redissonClient.getSet(key);
	}

	@Override
	public <T> RScoredSortedSet<T> getScoredSortedSet(String key) {
		return redissonClient.getScoredSortedSet(key);
	}

	@Override
	public RLock getLock(String key) {
		return redissonClient.getLock(key);
	}

	@Override
	public long remainTimeToLive(String key) {
		return redissonClient.getKeys().remainTimeToLive(key);
	}

	@PreDestroy
	public void destroy() {
		// 在程序关闭时，添加一个钩子函数用来释放链接资源 关闭Redisson客户端
		if (!redissonClient.isShutdown()) {
			Runtime.getRuntime().addShutdownHook(new Thread(redissonClient::shutdown));
		}
	}
}
