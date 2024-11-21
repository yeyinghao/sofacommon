/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.sofa.bootstrap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 计划配置
 *
 * @author yeyinghao
 * @date 2024/03/18
 */
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

	/**
	 * 配置任务
	 *
	 * @param taskRegistrar 任务注册器
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(threadPoolTaskScheduler());
	}

	/**
	 * 线程池任务计划程序
	 *
	 * @return {@link ThreadPoolTaskScheduler}
	 */
	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		// 配置线程池大小
		threadPoolTaskScheduler.setPoolSize(20);
		// 设置线程名
		threadPoolTaskScheduler.setThreadNamePrefix("smy-scheduling-");
		// 设置等待任务在关机时完成
		// threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
		// 设置等待终止时间
		// threadPoolTaskScheduler.setAwaitTerminationSeconds(60);
		return threadPoolTaskScheduler;
	}

}