package com.mk.demos.spring.cloud.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author WangChen
 * Created on 2022/9/9
 * @since 1.0
 */
@SpringBootApplication
public class ConfigClientRun {
    /**
     * 要读取配置中心的内容，需要增加相关的配置类，
     * Spring Cloud Config 读取配置中心内容的方式和读取本地配置文件中的配置是一模一样的。
     * 可以通过 @Value 或 @ConfigurationProperties 来获取。
     *
     * 想要自动刷新的话。使用@RefreshScope 注解并结合 actuator ，
     * 注意要引入 spring-boot-starter-actuator 包。
     * 注意，还是需要手动POST请求http://ip:port/actuator/refresh才能刷新
     * 可以结合github或gitlab的Webhook功能来代替手动调用,
     * 在Webhook中配置 http://ip:port/actuator/refresh，
     * 当git仓库中的配置修改后，会自动调用actuator/refresh接口
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientRun.class, args);
    }

}
