package com.mk.demos.spring.cloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 *
 * @author WangChen
 * Created on 2022/9/8
 * @since 1.0
 */
@SpringBootApplication
// @EnableDiscoveryClient 注解表示支持服务发现
@EnableDiscoveryClient // 也可以不显示使用@EnableDiscoveryClient，使用springboot自动装配机制也可以
public class ConsulProvider1Run {

    public static void main(String[] args) {
        SpringApplication.run(ConsulProvider1Run.class, args);
    }

}
