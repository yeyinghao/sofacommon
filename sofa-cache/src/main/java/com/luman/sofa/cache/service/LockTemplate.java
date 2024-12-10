package com.luman.sofa.cache.service;


import com.luman.sofa.dto.enums.ByLockCode;

import java.util.function.Supplier;

/**
 * 锁tmeplate
 *
 * @author yeyinghao
 * @date 2024/04/11
 */
public interface LockTemplate {

	/**
	 * 锁
	 *
	 * @param byLockCode 基础枚举
	 * @param bizId    业务id
	 * @param runnable 可运行
	 */
	void lock(ByLockCode byLockCode, Object bizId, Runnable runnable);

	/**
	 * 锁
	 *
	 * @param byLockCode 基础枚举
	 * @param bizId    业务id
	 * @param supplier 供应商
	 * @return {@link R}
	 */
	<R> R lock(ByLockCode byLockCode, Object bizId, Supplier<R> supplier);

	/**
	 * 试着锁
	 *
	 * @param byLockCode 基础枚举
	 * @param bizId    业务id
	 * @param runnable 可运行
	 */
	void tryLock(ByLockCode byLockCode, Object bizId, Runnable runnable);

	/**
	 * 试着锁
	 *
	 * @param byLockCode 基础枚举
	 * @param bizId    业务id
	 * @param supplier 供应商
	 * @return {@link R}
	 */
	<R> R tryLock(ByLockCode byLockCode, Object bizId, Supplier<R> supplier);

	/**
	 * 试锁
	 *
	 * @param byLockCode 基础枚举
	 * @param bizId    业务id
	 * @param runnable 可运行
	 */
	void tryLockEx(ByLockCode byLockCode, Object bizId, Runnable runnable);

	/**
	 * 试锁
	 *
	 * @param byLockCode 基础枚举
	 * @param bizId    业务id
	 * @param supplier 供应商
	 * @return {@link R}
	 */
	<R> R tryLockEx(ByLockCode byLockCode, Object bizId, Supplier<R> supplier);

}
