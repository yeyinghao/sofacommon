package com.luman.sofa.common.dal.interceptor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * 字段信息
 *
 * @author Zijian Liao
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
public class FieldInfo implements Serializable {

	private Object entity;

	private Field field;

	private Object data;

	public FieldInfo(Object entity, Field field, Object data) {
		this.entity = entity;
		this.field = field;
		this.data = data;
	}
}
