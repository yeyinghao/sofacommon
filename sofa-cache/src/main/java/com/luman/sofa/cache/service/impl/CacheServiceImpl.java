/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.10
 */

package com.luman.sofa.cache.service.impl;

import com.luman.sofa.cache.integration.CacheClient;
import com.luman.sofa.cache.integration.config.CacheConfig;
import com.luman.sofa.cache.service.CacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.*;
import org.springframework.stereotype.Service;

/**
 * 缓存服务实现
 *
 * @author yeyinghao
 * @date 2024/04/04
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService {

	/**
	 * redisson client对象
	 */
	private final CacheClient cacheClient;

	/**
	 * redisson配置
	 */
	private final CacheConfig redissonConfig;

	@Override
	public <T> T get(String key) {
		return cacheClient.get(getRealKey(key));
	}

	@Override
	public <T> void save(String key, T value) {
		cacheClient.save(getRealKey(key), value);
	}

	@Override
	public <T> void saveExpire(String key, T value, long expired) {
		cacheClient.saveExpire(getRealKey(key), value, expired);
	}

	@Override
	public <T> boolean trySave(String key, T value) {
		return cacheClient.trySave(getRealKey(key), value);
	}

	@Override
	public <T> boolean trySaveExpire(String key, T value, long expired) {
		return cacheClient.trySaveExpire(getRealKey(key), value, expired);
	}

	@Override
	public void delete(String key) {
		cacheClient.delete(getRealKey(key));
	}

	@Override
	public boolean isExists(String key) {
		return cacheClient.isExists(getRealKey(key));
	}

	@Override
	public <T> RList<T> getList(String key) {
		return cacheClient.getList(getRealKey(key));
	}

	@Override
	public <K, V> RMapCache<K, V> getMapCache(String key) {
		return cacheClient.getMapCache(getRealKey(key));
	}

	@Override
	public <K, V> RMap<K, V> getMap(String key) {
		return cacheClient.getMap(getRealKey(key));
	}

	@Override
	public <T> RSet<T> getSet(String key) {
		return cacheClient.getSet(getRealKey(key));
	}

	@Override
	public <T> RScoredSortedSet<T> getScoredSortedSet(String key) {
		return cacheClient.getScoredSortedSet(getRealKey(key));
	}

	@Override
	public RLock getLock(String key) {
		return cacheClient.getLock(getRealKey(key));
	}

	@Override
	public long remainTimeToLiveSecond(String key) {
		return cacheClient.remainTimeToLive(getRealKey(key)) / 1000;
	}

	private String getRealKey(String key) {
		return redissonConfig.getRealKey(key);
	}
}
