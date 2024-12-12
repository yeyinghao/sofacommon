package com.luman.sofa.common.dal.encrypt.handler;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.luman.sofa.common.dal.encrypt.config.EncryptProperties;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;

import java.nio.charset.StandardCharsets;

/**
 * 加解密工具
 *
 * @author Zijian Liao
 * @since 1.0.0
 */
public class EncryptHandler implements InitializingBean {

	@Resource
	private EncryptProperties encryptProperties;

	private SymmetricCrypto aes;

	public String encrypt(String data) {
		return aes.encryptHex(data);
	}

	public String decrypt(String data) {
		return aes.decryptStr(data, CharsetUtil.CHARSET_UTF_8);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		aes = new SymmetricCrypto(SymmetricAlgorithm.AES, encryptProperties.getSecret().getBytes(StandardCharsets.UTF_8));
	}
}
