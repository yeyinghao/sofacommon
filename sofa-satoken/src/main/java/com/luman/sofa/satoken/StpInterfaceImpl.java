/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.sofa.satoken;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import com.luman.sofa.satoken.constant.SaTokenConstant;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 鉴权
 *
 * @author yeyinghao
 * @date 2024/02/28
 */
@Component
public class StpInterfaceImpl implements StpInterface {

	/**
	 * 获取权限列表
	 *
	 * @param loginId   登录id
	 * @param loginType 登录类型
	 * @return {@link List}<{@link String}>
	 */
	@Override
	public List<String> getPermissionList(Object loginId, String loginType) {
		return null;
	}

	/**
	 * 获取角色列表
	 *
	 * @param loginId   登录id
	 * @param loginType 登录类型
	 * @return {@link List}<{@link String}>
	 */
	@Override
	public List<String> getRoleList(Object loginId, String loginType) {
		String role = (String) StpUtil.getExtra(SaTokenConstant.JWT_CURRENT_ROLE_KEY);
		return CollUtil.newArrayList(role);
	}
}
