/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.10
 */

package com.luman.sofa.cache.integration;

import org.redisson.api.*;

/**
 * 缓存服务
 *
 * @author yeyinghao
 * @date 2023/09/17
 */
public interface CacheClient {

	/**
	 * 得到对象
	 *
	 * @param key 缓存key
	 * @return 缓存返回值
	 */
	<T> T get(String key);

	/**
	 * 保存对象
	 *
	 * @param key   关键
	 * @param value 价值
	 */
	<T> void save(String key, T value);

	/**
	 * 保存字符串过期
	 *
	 * @param key     缓存key
	 * @param value   缓存值
	 * @param expired 缓存过期时间
	 */
	<T> void saveExpire(String key, T value, long expired);

	/**
	 * 获取key过期时间(秒)
	 *
	 * @param key key
	 * @return long
	 */
	long remainTimeToLive(String key);

	/**
	 * 如果没有则保存字符串
	 *
	 * @param key   缓存key
	 * @param value 缓存值
	 * @return boolean
	 */
	<T> boolean trySave(String key, T value);

	/**
	 * 如果没有，保存字符串过期
	 *
	 * @param key     缓存key
	 * @param value   缓存值
	 * @param expired 缓存过期时间
	 * @return boolean
	 */
	<T> boolean trySaveExpire(String key, T value, long expired);

	/**
	 * 删除
	 *
	 * @param key 关键
	 */
	void delete(String key);

	/**
	 * 存在
	 *
	 * @param key 关键
	 * @return boolean
	 */
	boolean isExists(String key);

	/**
	 * 获取redis列表
	 *
	 * @param key 关键
	 * @return {@link RList}<{@link T}>
	 */
	<T> RList<T> getList(String key);

	/**
	 * 获取redis映射缓存
	 *
	 * @param key 关键
	 * @return {@link RMapCache}<{@link K}, {@link V}>
	 */
	<K, V> RMapCache<K, V> getMapCache(String key);

	/**
	 * 获取redis地图
	 *
	 * @param key 关键
	 * @return {@link RMap}<{@link K}, {@link V}>
	 */
	<K, V> RMap<K, V> getMap(String key);

	/**
	 * 设置redis
	 *
	 * @param key 关键
	 * @return {@link RSet}<{@link T}>
	 */
	<T> RSet<T> getSet(String key);

	/**
	 * 得到redis评分排序集
	 *
	 * @param key 关键
	 * @return {@link RScoredSortedSet}<{@link T}>
	 */
	<T> RScoredSortedSet<T> getScoredSortedSet(String key);

	/**
	 * 获取redis锁
	 *
	 * @param key 关键
	 * @return {@link RLock}
	 */
	RLock getLock(String key);
}
