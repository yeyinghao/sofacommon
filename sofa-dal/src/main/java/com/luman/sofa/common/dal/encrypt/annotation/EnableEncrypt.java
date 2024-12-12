package com.luman.sofa.common.dal.encrypt.annotation;

import com.luman.sofa.common.dal.encrypt.config.EncryptProperties;
import com.luman.sofa.common.dal.encrypt.handler.EncryptHandler;
import com.luman.sofa.common.dal.encrypt.interceptor.FieldDecryptInterceptor;
import com.luman.sofa.common.dal.encrypt.interceptor.FieldEncryptInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({EncryptHandler.class, FieldEncryptInterceptor.class, FieldDecryptInterceptor.class})
@EnableConfigurationProperties(EncryptProperties.class)
@Documented
public @interface EnableEncrypt {
}
