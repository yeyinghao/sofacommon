package com.luman.sofa.cache.service;


import com.luman.sofa.model.enums.ByStringCode;

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
	 * @param byStringCode 基础枚举
	 * @param bizId    业务id
	 * @param runnable 可运行
	 */
	void lock(ByStringCode byStringCode, Object bizId, Runnable runnable);

	/**
	 * 锁
	 *
	 * @param byStringCode 基础枚举
	 * @param bizId    业务id
	 * @param supplier 供应商
	 * @return {@link R}
	 */
	<R> R lock(ByStringCode byStringCode, Object bizId, Supplier<R> supplier);

	/**
	 * 试着锁
	 *
	 * @param byStringCode 基础枚举
	 * @param bizId    业务id
	 * @param runnable 可运行
	 */
	void tryLock(ByStringCode byStringCode, Object bizId, Runnable runnable);

	/**
	 * 试着锁
	 *
	 * @param byStringCode 基础枚举
	 * @param bizId    业务id
	 * @param supplier 供应商
	 * @return {@link R}
	 */
	<R> R tryLock(ByStringCode byStringCode, Object bizId, Supplier<R> supplier);

	/**
	 * 试锁
	 *
	 * @param byStringCode 基础枚举
	 * @param bizId    业务id
	 * @param runnable 可运行
	 */
	void tryLockEx(ByStringCode byStringCode, Object bizId, Runnable runnable);

	/**
	 * 试锁
	 *
	 * @param byStringCode 基础枚举
	 * @param bizId    业务id
	 * @param supplier 供应商
	 * @return {@link R}
	 */
	<R> R tryLockEx(ByStringCode byStringCode, Object bizId, Supplier<R> supplier);

}
