package com.mk.demos.spring.boot.apiversion.config;

import com.mk.demos.spring.boot.apiversion.handler.ApiRequestMappingHandlerMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * WebMvcRegistrationsConfig
 *
 * @author WangChen
 * Created on 2019/10/24 17:21
 * @since 1.0
 */
@Configuration
public class WebMvcRegistrationsConfig implements WebMvcRegistrations {
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new ApiRequestMappingHandlerMapping(1, true);
    }
}
