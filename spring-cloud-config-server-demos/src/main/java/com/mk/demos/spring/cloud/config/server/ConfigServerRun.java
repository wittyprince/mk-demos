package com.mk.demos.spring.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 启动类
 *
 * @author WangChen
 * Created on 2022/9/9
 * @since 1.0
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerRun {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerRun.class, args);
    }
}
