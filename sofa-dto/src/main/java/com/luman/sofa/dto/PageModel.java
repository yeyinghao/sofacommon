package com.luman.sofa.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * 页面模型
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings({"unchecked", "unused"})
public class PageModel<T> extends DTO {

	/**
	 * 串口版本uid
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 页面大小
	 */
	private Long pageSize;

	/**
	 * 页面索引
	 */
	private Long pageIndex;

	/**
	 * 总大小
	 */
	private Long totalSize;

	/**
	 * 集合
	 */
	private List<T> records;

	/**
	 * @param records
	 * @return {@link PageModel }<{@link T }>
	 */
	public PageModel<T> setRecords(List<T> records) {
		this.records = records;
		return this;
	}

	/**
	 * IPage 的泛型转换
	 *
	 * @param mapper 转换函数
	 * @return 转换泛型后的 IPage
	 */
	public <R> PageModel<R> convert(Function<? super T, ? extends R> mapper) {
		List<R> collect = this.getRecords().stream().map(mapper).collect(toList());
		return ((PageModel<R>) this).setRecords(collect);
	}
}
