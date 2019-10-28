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

    private String apiVersion = "1.0";
    // 保存所有接口的最大版本号
    private static String maxVersion = "1.0";

    ApiVersionCondition(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public static void setMaxVersion(String maxVersion) {
        ApiVersionCondition.maxVersion = maxVersion;
    }

    public static String getMaxVersion() {
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
            String version = m.group(0);
            if (/*version <= maxVersion && */versionCompare(version, this.apiVersion) >= 0) {
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        return versionCompare(apiVersionCondition.getApiVersion(), this.apiVersion);
    }

    public static int versionCompare(String version1, String version2) {
        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");

        int i = 0;
        int diff = 0;
        diff = v1Arr.length - v2Arr.length;

        while (diff == 0 && i < v1Arr.length
                && (diff = v1Arr[i].length() - v2Arr[i].length()) == 0
                && (diff = v1Arr[i].compareToIgnoreCase(v2Arr[i])) == 0) {
            ++i;
        }
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return -1;
        }
        return 0;
    }
}
