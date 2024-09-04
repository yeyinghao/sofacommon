package com.luman.sofa.common.validator;

import com.luman.sofa.common.enums.ByStringCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

/**
 * enumvaluevalidator
 *
 * @author yeyinghao
 * @date 2024/09/04
 */
public class EnumValueValidator implements ConstraintValidator<EnumValue, String> {

	private boolean nullable;

	private Set<String> vals;

	/**
	 * 初始化校验器，获取注解中的属性并记录下来
	 */
	@Override
	public void initialize(EnumValue constraintAnnotation) {
		this.nullable = constraintAnnotation.nullable();
		Class<? extends ByStringCode> enumClass = constraintAnnotation.enumClass();
		String[] exclusions = constraintAnnotation.exclusion();
		vals = new HashSet<>();
		ByStringCode[] enumConstants = enumClass.getEnumConstants();
		for (ByStringCode byStringCode : enumConstants) {
			vals.add(byStringCode.getCode());
		}
		for (String exclusion : exclusions) {
			vals.remove(exclusion);
		}
	}

	/**
	 * 校验参数是否合法
	 */
	@Override
	public boolean isValid(String param, ConstraintValidatorContext context) {
		if (nullable && param == null) {
			return true;
		}
		return vals.contains(param);
	}
}
