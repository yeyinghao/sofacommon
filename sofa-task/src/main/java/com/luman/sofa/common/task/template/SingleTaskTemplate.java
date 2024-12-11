package com.luman.sofa.common.task.template;

import com.luman.sofa.common.exception.BizException;
import com.luman.sofa.common.task.TaskService;
import com.luman.sofa.common.task.model.TaskResult;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;

/**
 * 任务模板
 *
 * @author yeyinghao
 * @date 2024/04/04
 */
public abstract class SingleTaskTemplate<T> implements BasicProcessor, TaskService<T> {

	/**
	 * 数据处理
	 *
	 * @return {@link T }
	 */
	protected abstract T data();

	@Override
	public ProcessResult process(TaskContext taskContext) throws Exception {
		TaskResult taskResultDP = TaskResult.init(byTaskCode());
		try {
			try {
				handle(data());
				taskResultDP.addSussNum();
				return new ProcessResult(true, "执行成功");
			} catch (BizException e) {
			} catch (Throwable e) {
			}
			taskResultDP.addFailNum();
		} finally {
		}
		return new ProcessResult(true, "执行成功");
	}
}
