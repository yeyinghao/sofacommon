/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.sofa.bootstrap.config;

import com.luman.sofa.common.constant.CommConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 执行器配置
 *
 * @author yeyinghao
 * @date 2024/02/28
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

	/**
	 * 线程池执行程序
	 *
	 * @return {@link Executor}
	 */
	@Bean(CommConstant.THREAD_POOL_EXECUTOR_DEFAULT)
	public Executor threadPoolExecutor() {
		ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
		int processNum = Runtime.getRuntime().availableProcessors(); // 返回可用处理器的Java虚拟机的数量
		int corePoolSize = (int) (processNum / (1 - 0.2));
		int maxPoolSize = (int) (processNum / (1 - 0.5));
		threadPoolExecutor.setCorePoolSize(corePoolSize); // 核心池大小
		threadPoolExecutor.setMaxPoolSize(maxPoolSize); // 最大线程数
		threadPoolExecutor.setQueueCapacity(maxPoolSize * 1000); // 队列程度
		threadPoolExecutor.setThreadPriority(Thread.MAX_PRIORITY);
		threadPoolExecutor.setDaemon(false);
		threadPoolExecutor.setKeepAliveSeconds(300);// 线程空闲时间
		threadPoolExecutor.setThreadNamePrefix("smy-executor-"); // 线程名字前缀
		return threadPoolExecutor;
	}

}