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
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile(".*(\\d+).*");

    private float apiVersion = 1;
    // 保存所有接口的最大版本号
    private static float maxVersion = 1;

    ApiVersionCondition(float apiVersion) {
        this.apiVersion = apiVersion;
    }

    public float getApiVersion() {
        return apiVersion;
    }

    public static void setMaxVersion(float maxVersion) {
        ApiVersionCondition.maxVersion = maxVersion;
    }

    public static float getMaxVersion() {
        return maxVersion;
    }

    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        return new ApiVersionCondition(apiVersionCondition.getApiVersion());
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        String apiVersion = httpServletRequest.getHeader("v");
        if (apiVersion == null){
            return this;
        }
        Matcher m = VERSION_PREFIX_PATTERN.matcher(apiVersion);
        if (m.find()) {
            float version = Float.parseFloat(m.group(0));
            if (/*version <= maxVersion && */version == this.apiVersion) {
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        return (int) (apiVersionCondition.getApiVersion() - this.apiVersion);
    }
}
