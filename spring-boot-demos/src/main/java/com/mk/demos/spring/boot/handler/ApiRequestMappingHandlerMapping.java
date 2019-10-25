package com.mk.demos.spring.boot.handler;

import java.lang.reflect.Method;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.mk.demos.spring.boot.annotation.ApiVersion;

/**
 * ApiRequestMappingHandlerMapping
 *
 * @author WangChen
 * Created on 2019/10/24 17:22
 * @since 1.0
 */
public class ApiRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
    private static final String VERSION_FLAG = "{version}";
    private int latestVersion = 1;

    private static RequestCondition<ApiVersionCondition> createCondition(Class<?> clazz) {
//        RequestMapping classRequestMapping = clazz.getAnnotation(RequestMapping.class);
//        if (classRequestMapping == null) {
//            return null;
//        }
//        StringBuilder mappingUrlBuilder = new StringBuilder();
//        if (classRequestMapping.value().length > 0) {
//            mappingUrlBuilder.append(classRequestMapping.value()[0]);
//        }
//        String mappingUrl = mappingUrlBuilder.toString();
//        if (!mappingUrl.contains(VERSION_FLAG)) {
//            return null;
//        }
        ApiVersion apiVersion = clazz.getAnnotation(ApiVersion.class);
        return apiVersion == null ? new ApiVersionCondition(1) : new ApiVersionCondition(apiVersion.value());
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        // 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
        ApiVersionCondition condition =  buildFrom(AnnotationUtils.findAnnotation(method, ApiVersion.class));
        // 保存最大版本号
        if (condition != null && condition.getApiVersion() > ApiVersionCondition.getMaxVersion()) {
            ApiVersionCondition.setMaxVersion(condition.getApiVersion());
        }
        return condition;
    }

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        // 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
        ApiVersionCondition condition = buildFrom(AnnotationUtils.findAnnotation(handlerType, ApiVersion.class));
        // 保存最大版本号
        if (condition != null && condition.getApiVersion() > ApiVersionCondition.getMaxVersion()) {
            ApiVersionCondition.setMaxVersion(condition.getApiVersion());
        }
        return condition;
    }

    private ApiVersionCondition buildFrom(ApiVersion apiVersion) {
        return apiVersion == null ? null : new ApiVersionCondition(apiVersion.value());
    }
}