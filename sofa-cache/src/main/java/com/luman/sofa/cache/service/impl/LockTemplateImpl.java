package com.luman.sofa.cache.service.impl;

import com.luman.sofa.cache.service.CacheService;
import com.luman.sofa.cache.service.LockTemplate;
import com.luman.sofa.common.constant.LoggerConstant;
import com.luman.sofa.common.enums.ErrorEnum;
import com.luman.sofa.common.exception.VarChecker;
import com.luman.sofa.dto.enums.ByLockCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.function.Supplier;

/**
 * 锁template实现
 *
 * @author yeyinghao
 * @date 2024/04/11
 */
@Component
@RequiredArgsConstructor
@Slf4j(topic = LoggerConstant.LOCK_LOG)
public class LockTemplateImpl implements LockTemplate {

	/**
	 * 缓存服务
	 */
	private final CacheService cacheService;

	@Override
	public void lock(ByLockCode byLockCode, Object bizId, Runnable runnable) {
		Lock rLock = getLock(byLockCode, bizId);
		try {
			rLock.lock();
			runnable.run();
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public <R> R lock(ByLockCode byLockCode, Object bizId, Supplier<R> supplier) {
		Lock rLock = getLock(byLockCode, bizId);
		try {
			rLock.lock();
			return supplier.get();
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public void tryLock(ByLockCode byLockCode, Object bizId, Runnable runnable) {
		Lock rLock = getLock(byLockCode, bizId);
		try {
			if (!rLock.tryLock()) {
				return;
			}
			runnable.run();
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public <R> R tryLock(ByLockCode byLockCode, Object bizId, Supplier<R> supplier) {
		Lock rLock = getLock(byLockCode, bizId);
		try {
			if (!rLock.tryLock()) {
				return null;
			}
			return supplier.get();
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public void tryLockEx(ByLockCode byLockCode, Object bizId, Runnable runnable) {
		Lock rLock = getLock(byLockCode, bizId);
		try {
			VarChecker.isTrue(rLock.tryLock(), ErrorEnum.BIZ_ERROR, "获取分布式锁失败");
			runnable.run();
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public <R> R tryLockEx(ByLockCode byLockCode, Object bizId, Supplier<R> supplier) {
		Lock rLock = getLock(byLockCode, bizId);
		try {
			VarChecker.isTrue(rLock.tryLock(), ErrorEnum.BIZ_ERROR, "获取分布式锁失败");
			return supplier.get();
		} finally {
			rLock.unlock();
		}
	}

	/**
	 * 获取rlock
	 *
	 * @param byLockCode 基础枚举
	 * @param bizId    业务id
	 * @return {@link Lock}
	 */
	private Lock getLock(ByLockCode byLockCode, Object bizId) {
		if (Objects.isNull(bizId)) {
			return cacheService.getLock(byLockCode.getCode());
		}
		return cacheService.getLock(byLockCode.getCode() + bizId);
	}
}
