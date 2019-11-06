package com.mk.demos.spring.boot.handler;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
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
        return apiVersion == null ? new ApiVersionCondition("1.0") : new ApiVersionCondition(apiVersion.value());
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        // 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
        ApiVersionCondition condition =  buildFrom(AnnotationUtils.findAnnotation(method, ApiVersion.class));
        // 保存最大版本号
        if (condition != null && ApiVersionCondition.versionCompare(condition.getApiVersion(), ApiVersionCondition.getMaxVersion()) >= 0) {
            ApiVersionCondition.setMaxVersion(condition.getApiVersion());
        }
        return condition;
    }

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        // 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
        ApiVersionCondition condition = buildFrom(AnnotationUtils.findAnnotation(handlerType, ApiVersion.class));
        // 保存最大版本号
        if (condition != null && ApiVersionCondition.versionCompare(condition.getApiVersion(), ApiVersionCondition.getMaxVersion()) >= 0) {
            ApiVersionCondition.setMaxVersion(condition.getApiVersion());
        }
        return condition;
    }

    private ApiVersionCondition buildFrom(ApiVersion apiVersion) {
        return apiVersion == null ? new ApiVersionCondition("1.5") : new ApiVersionCondition(apiVersion.value());
    }

    private final static Map<HandlerMethod, RequestMappingInfo> HANDLER_METHOD_REQUEST_MAPPING_INFO_MAP = new HashMap<>();

    // 用于保存处理方法和RequestMappingInfo的映射关系(这个方法在解析@RequestMapping时就会被调用, 达达科技中这个地方可能写的有问题, 文中提到覆写AbstractHandlerMethodMapping#registerMapping方法, 但是经过实验之后覆写这个方法不能生效)
    @Override
    protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {
        HandlerMethod handlerMethod = super.createHandlerMethod(handler, method);
        HANDLER_METHOD_REQUEST_MAPPING_INFO_MAP.put(handlerMethod, mapping);
        super.registerHandlerMethod(handler, method, mapping);
    }

    @Override
    protected HandlerMethod lookupHandlerMethod(String lookupPath, HttpServletRequest request) throws Exception {

        // 判断请求参数中是否带了event字段
        String event = request.getParameter("event");

        // 如果没有带则说明这次的请求不带路径参数, 则使用默认的处理
        if(StringUtils.isEmpty(event)) {
            return super.lookupHandlerMethod(lookupPath, request);
        }

        // 如果带了, 则从Map(这个Map中的entry在后面介绍)中获取处理当前url的方法
        List<HandlerMethod> handlerMethods = super.getHandlerMethodsForMappingName(event);
        if(CollectionUtils.isEmpty(handlerMethods)) throw new RuntimeException("没有找到指定的方法");
        if(handlerMethods.size() > 1) throw new RuntimeException("存在多个匹配的方法");

        HandlerMethod handlerMethod = handlerMethods.get(0);

        // 根据处理方法查找RequestMappingInfo, 用于解析路径url中的参数
        RequestMappingInfo requestMappingInfo = HANDLER_METHOD_REQUEST_MAPPING_INFO_MAP.get(handlerMethod);
        if(requestMappingInfo == null) throw new RuntimeException("没有对应的匹配方法");
        super.handleMatch(requestMappingInfo, lookupPath, request);
        return handlerMethod;
    }
}