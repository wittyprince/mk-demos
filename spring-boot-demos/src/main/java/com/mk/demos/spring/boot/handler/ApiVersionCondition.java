package com.mk.demos.spring.boot.handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

/**
 * ApiVersionCondition
 *
 * @author WangChen
 * Created on 2019/10/24 17:24
 * @since 1.0
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile(".*v(\\d+).*");

    private int apiVersion;

    ApiVersionCondition(int apiVersion) {
        this.apiVersion = apiVersion;
    }

    private int getApiVersion() {
        return apiVersion;
    }


    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        return new ApiVersionCondition(apiVersionCondition.getApiVersion());
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
        if (m.find()) {
            Integer version = Integer.valueOf(m.group(1));
            if (version >= this.apiVersion) {
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        return apiVersionCondition.getApiVersion() - this.apiVersion;
    }
}
