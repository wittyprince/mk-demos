package com.mk.demos.spring.boot.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.Mapping;

/**
 * ApiVersion
 *
 * @author WangChen
 * Created on 2019/10/24 17:23
 * @since 1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Mapping
public @interface ApiVersion {
    /**
     * @return 版本号
     */
    int value() default 1;
}
