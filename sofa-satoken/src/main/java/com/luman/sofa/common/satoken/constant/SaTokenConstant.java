/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.sofa.common.satoken.constant;


import com.luman.sofa.common.constant.BaseConstant;

/**
 * sa令牌常数
 *
 * @author yeyinghao
 * @date 2024/04/04
 */
public interface SaTokenConstant extends BaseConstant {

	/**
	 * jwt用户idkey
	 */
	String JWT_ID_KEY = "id";

	/**
	 * jwt用户idkey
	 */
	String JWT_USER_ID_KEY = "userId";

	/**
	 * jwt用户codekey
	 */
	String JWT_USER_CODE_KEY = "userCode";

	/**
	 * jwt用户名key
	 */
	String JWT_USERNAME_KEY = "userName";

	/**
	 * jwt角色列表key
	 */
	String JWT_ROLE_LIST_KEY = "roleCodes";

	/**
	 * jwtcurrent角色key
	 */
	String JWT_CURRENT_ROLE_KEY = "currentRoleCode";

}
