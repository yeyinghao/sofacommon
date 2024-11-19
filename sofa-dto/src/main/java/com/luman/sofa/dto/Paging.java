package com.luman.sofa.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 分页
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
@EqualsAndHashCode(callSuper = true)
@Data
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
}
