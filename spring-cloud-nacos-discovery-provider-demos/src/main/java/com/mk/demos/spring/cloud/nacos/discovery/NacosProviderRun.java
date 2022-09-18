package com.mk.demos.spring.cloud.nacos.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * run
 *
 * @author WangChen
 * Created on 2022/6/26
 * @since 1.0.0
 */
@SpringBootApplication
// 也可以不显示使用@EnableDiscoveryClient，使用springboot自动装配机制也可以
@EnableDiscoveryClient
public class NacosProviderRun {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderRun.class, args);
    }
}
