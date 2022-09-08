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
@EnableDiscoveryClient
public class ConsulProvider2Run {

    public static void main(String[] args) {
        SpringApplication.run(ConsulProvider2Run.class, args);
    }

}
