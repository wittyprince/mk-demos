package com.mk.demos.spring.cloud.config.client;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 读取配置
 *
 * 要读取配置中心的内容，需要增加相关的配置类，
 * Spring Cloud Config 读取配置中心内容的方式和读取本地配置文件中的配置是一模一样的。
 * 可以通过 @Value 或 @ConfigurationProperties 来获取。
 *
 * @author WangChen
 * Created on 2022/9/9
 * @since 1.0
 */
@Data
@Component
public class GitConfig {

    @Value("${data.env}")
    private String env;

    @Value("${data.user.username}")
    private String username;

    @Value("${data.user.password}")
    private String password;
}
