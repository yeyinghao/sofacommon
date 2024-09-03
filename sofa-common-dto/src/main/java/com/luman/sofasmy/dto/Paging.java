package com.luman.sofasmy.dto;

import java.io.Serial;

/**
 * 分页
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
public class Paging extends DTO {

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

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}
}
