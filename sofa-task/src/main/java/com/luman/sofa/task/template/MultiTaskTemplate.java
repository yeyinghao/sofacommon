package com.luman.sofa.task.template;


import com.luman.sofa.common.exception.BizException;
import com.luman.sofa.task.TaskService;
import com.luman.sofa.task.model.TaskResult;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;

import java.util.List;

/**
 * 任务模板
 *
 * @author yeyinghao
 * @date 2024/04/04
 */
public abstract class MultiTaskTemplate<T> implements BasicProcessor, TaskService<T> {

	/**
	 * 数据处理
	 *
	 * @return {@link List}<{@link T}>
	 */
	protected abstract List<T> datas();

	@Override
	public ProcessResult process(TaskContext taskContext) throws Exception {
		TaskResult taskResultDP = TaskResult.init(byTaskCode());
		try {
			datas().forEach(item -> {
				try {
					handle(item);
					taskResultDP.addSussNum();
					return;
				} catch (BizException e) {
				} catch (Throwable e) {
				}
				taskResultDP.addFailNum();
			});
		} finally {
		}
		return new ProcessResult(true, "任务执行成功");
	}
}
