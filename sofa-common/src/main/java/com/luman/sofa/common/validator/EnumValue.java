package com.luman.sofa.common.validator;

import com.luman.sofa.common.enums.ByStringCode;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义参数验d证注解, 用于验证枚举类的 int 值作为参数
 */
@Retention(RetentionPolicy.RUNTIME)
// 这个注解是validation提供的，用于指定对应的校验器
@Constraint(validatedBy = EnumValueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface EnumValue {

	String message() default "枚举值不合法";

	/**
	 * @return 指定分组
	 */
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * @return 指定枚举类型，参数值必须是这个枚举类型中的值
	 */
	Class<? extends ByStringCode> enumClass();

	/**
	 * @return 是否可以为 null
	 */
	boolean nullable() default false;

	/**
	 * @return 需要排除的值
	 */
	String[] exclusion() default {};

}
