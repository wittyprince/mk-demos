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
@EnableDiscoveryClient
public class NacosProviderRun {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderRun.class, args);
    }
}
