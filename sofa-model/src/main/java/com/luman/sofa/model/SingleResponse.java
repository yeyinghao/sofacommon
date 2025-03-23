package com.luman.sofa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 响应
 *
 * @author yeyinghao
 * @date 2024/03/29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SingleResponse<T> extends Response {

	/**
	 * 串口版本uid
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 数据
	 */
	private T data;

}
