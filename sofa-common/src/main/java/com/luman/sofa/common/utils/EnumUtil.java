package com.luman.sofa.common.utils;

import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Lists;
import com.luman.sofa.common.dto.EnumVO;
import com.luman.sofa.common.enums.ByCode;
import com.luman.sofa.common.exception.BizException;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
	public static <M extends ByCode<T>, T> Optional<M> getEnumByCode(Class<M> type, T code) {
		if (!type.isEnum()) {
			return Optional.empty();
		}
		M[] enums = type.getEnumConstants();
		for (M em : enums) {
			if (Objects.equals(em.getCode(), code)) {
				return Optional.of(em);
			}
		}
		return Optional.empty();
	}

	public static <M extends ByCode<T>, T, EX extends BizException> List<M> getEnumsByCodes(Class<M> type, List<T> codes) {
		if (!type.isEnum()) {
			return Lists.newArrayList();
		}
		return codes.stream().map(item -> EnumUtil.getEnumByCode(type, item).orElse(null)).filter(Objects::nonNull).toList();
	}

	/**
	 * 获取名称
	 *
	 * @param byCode 基础枚举
	 * @return {@link T }
	 */
	public static <M extends ByCode<T>, T> T getName(M byCode) {
		return Optional.ofNullable(byCode).map(ByCode::getCode).orElse(null);
	}

	/**
	 * 获取名称
	 *
	 * @param byCodes 基础枚举
	 * @return {@link T }
	 */
	public static <M extends ByCode<T>, T> List<T> getNames(List<M> byCodes) {
		if (CollUtil.isEmpty(byCodes)) {
			return Lists.newArrayList();
		}
		return byCodes.stream().map(EnumUtil::getName).toList();
	}

	public static <M extends ByCode<T>, T> EnumVO toEnumVO(M byCode) {
		return Optional.ofNullable(byCode).map(EnumVO::new).orElse(null);
	}

	public static <M extends ByCode<T>, T> List<EnumVO> toEnumVOs(List<M> byCodes) {
		if (CollUtil.isEmpty(byCodes)) {
			return Lists.newArrayList();
		}
		return byCodes.stream().map(EnumVO::new).toList();
	}

}
