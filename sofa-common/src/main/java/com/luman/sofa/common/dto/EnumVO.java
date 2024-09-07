package com.luman.sofa.common.dto;

import com.luman.sofa.common.enums.ByCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * 分页
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
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

	public <M extends ByCode<T>, T> EnumVO(M byCode) {
		this.code = String.valueOf(byCode.getCode());
		this.desc = byCode.getDesc();
	}
}
