package com.luman.sofa.common.dal.annotation;

import com.luman.sofa.common.dal.config.EncryptProperties;
import com.luman.sofa.common.dal.handler.EncryptHandler;
import com.luman.sofa.common.dal.interceptor.FieldDecryptInterceptor;
import com.luman.sofa.common.dal.interceptor.FieldEncryptInterceptor;
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
