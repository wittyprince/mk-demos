package com.mk.demos.spring.boot.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author WangChen
 * Created on 2022/9/11
 * @since 1.0
 */

// 开启基于注解的dubbo功能（主要是包扫描@DubboComponentScan）
// 也可以在配置文件中使用dubbo.scan.base-package来替代   @EnableDubbo
@EnableDubbo

@SpringBootApplication
public class ProviderRun {

    public static void main(String[] args) {
        SpringApplication.run(ProviderRun.class, args);
    }
}
