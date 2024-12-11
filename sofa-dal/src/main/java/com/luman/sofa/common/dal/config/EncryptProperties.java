package com.luman.sofa.common.dal.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Zijian Liao
 * @since 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "smy.encrypt")
public class EncryptProperties {
	private String secret;
}
