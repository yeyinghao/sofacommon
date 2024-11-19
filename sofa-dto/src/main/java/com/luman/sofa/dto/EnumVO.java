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
public class EnumVO extends VO {

	/**
	 * 串口版本uid
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 枚举code
	 */
	private String code;

	/**
	 * 枚举描述
	 */
	private String desc;
}
