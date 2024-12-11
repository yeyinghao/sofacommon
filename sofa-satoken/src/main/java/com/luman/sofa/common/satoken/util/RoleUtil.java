/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.3
 */

package com.luman.sofa.common.satoken.util;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.luman.sofa.common.satoken.constant.SaTokenConstant;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * env工具类
 *
 * @author yeyinghao
 * @date 2024/03/17
 */
@Component
@Data
public class RoleUtil {

	/**
	 * 判断登录角色和传入的角色是否一致
	 *
	 * @return boolean
	 */
	public boolean equals(String roleCode) {
		String curRoleCode = (String) StpUtil.getExtra(SaTokenConstant.JWT_CURRENT_ROLE_KEY);
		return StrUtil.equals(curRoleCode, roleCode);
	}

}
