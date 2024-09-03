package com.luman.sofasmy.dto;

import java.io.Serial;

/**
 * 页面查询
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
public abstract class PageQuery extends Query {

	/**
	 * 串口版本uid
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 分页
	 */
	private Paging paging;

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}
}
