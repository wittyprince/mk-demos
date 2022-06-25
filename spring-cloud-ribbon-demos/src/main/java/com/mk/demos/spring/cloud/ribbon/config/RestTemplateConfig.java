package com.mk.demos.spring.cloud.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * config
 *
 * @author WangChen
 * Created on 2022/6/24
 * @since 1.0.0
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced // @LoadBalanced 让RestTemplate启用客户端负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
