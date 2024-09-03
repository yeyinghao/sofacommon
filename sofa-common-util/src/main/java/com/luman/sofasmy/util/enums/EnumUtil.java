package com.luman.sofasmy.util.enums;

import lombok.experimental.UtilityClass;

import java.util.Objects;

/**
 * 枚举工具类
 *
 * @author yeyinghao
 * @date 2024/08/26
 */
@UtilityClass
public class EnumUtil {

	/**
	 * 获取枚举通过代码
	 *
	 * @param type 类型
	 * @param code 代码
	 * @return {@link M }
	 */
	public static <M extends ByCode<T>, T> M getEnumByCode(Class<M> type, T code) {
		if (!type.isEnum()) {
			return null;
		}
		M[] enums = type.getEnumConstants();
		for (M em : enums) {
			if (Objects.equals(em.getCode(), code)) {
				return em;
			}
		}
		return null;
	}

	/**
	 * 获取名称
	 *
	 * @param baseEnum 基础枚举
	 * @return {@link T }
	 */
	public static <M extends ByCode<T>, T> T getName(M baseEnum) {
		return Objects.isNull(baseEnum) ? null : baseEnum.getCode();
	}

}
