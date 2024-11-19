package com.luman.sofa.dto;

import java.io.Serial;

/**
 * 分页
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
