/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.3
 */

package com.luman.sofa.common.task.model;

import com.luman.sofa.dto.enums.ByTaskCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 任务结果vo
 *
 * @author yeyinghao
 * @date 2024/03/06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResult {

	/**
	 * 任务枚举
	 */
	private ByTaskCode byTaskCode;

	/**
	 * 总num
	 */
	private Integer totalNum;

	/**
	 * 成功num
	 */
	private Integer succNum;

	/**
	 * 失败num
	 */
	private Integer failNum;

	/**
	 * ext信息
	 */
	private Map<String, Object> extInfo;

	/**
	 * 成功数加1
	 */
	public void addSussNum() {
		this.succNum += 1;
		this.totalNum += 1;
	}

	/**
	 * 失败数加1
	 */
	public void addFailNum() {
		this.failNum += 1;
		this.totalNum += 1;
	}

	/**
	 * Init任务结果dp
	 *
	 * @return {@link TaskResult}
	 */
	public static TaskResult init(ByTaskCode byTaskCode) {
		return TaskResult.builder().byTaskCode(byTaskCode).totalNum(0).succNum(0).failNum(0).build();
	}
}
