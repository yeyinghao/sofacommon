package com.luman.sofa.common.dal.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * dto
 *
 * @author yeyinghao
 * @date 2024/08/19
 */
@Data
@ToString
public class DP implements Serializable {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

	/**
	 * 状态
	 */
	private Boolean status;

}
