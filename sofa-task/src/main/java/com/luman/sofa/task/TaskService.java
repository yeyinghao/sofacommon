package com.luman.sofa.task;

import com.luman.sofa.dto.enums.ByTaskCode;
import org.springframework.boot.ApplicationRunner;

/**
 * 任务服务
 *
 * @author yeyinghao
 * @date 2024/04/05
 */
public interface TaskService<T> extends ApplicationRunner {

	/**
	 * doHandle
	 *
	 * @param t t
	 */
	void handle(T t);

	ByTaskCode byTaskCode();
}
