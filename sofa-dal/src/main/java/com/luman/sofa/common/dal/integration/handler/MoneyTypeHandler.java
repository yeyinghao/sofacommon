/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.3
 */

package com.luman.sofa.common.dal.integration.handler;

import cn.hutool.core.math.MathUtil;
import cn.hutool.core.math.Money;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 货币类型处理器
 *
 * @author yeyinghao
 * @date 2024/03/21
 */
@SuppressWarnings("unused")
public class MoneyTypeHandler extends BaseTypeHandler<Money> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Money money, JdbcType jdbcType) throws SQLException {
		ps.setLong(i, money.getCent());
	}

	@Override
	public Money getNullableResult(ResultSet rs, String s) throws SQLException {
		return new Money(MathUtil.centToYuan(rs.getLong(s)));
	}

	@Override
	public Money getNullableResult(ResultSet rs, int i) throws SQLException {
		return new Money(MathUtil.centToYuan(rs.getLong(i)));
	}

	@Override
	public Money getNullableResult(CallableStatement cs, int i) throws SQLException {
		return new Money(MathUtil.centToYuan(cs.getLong(i)));
	}
}