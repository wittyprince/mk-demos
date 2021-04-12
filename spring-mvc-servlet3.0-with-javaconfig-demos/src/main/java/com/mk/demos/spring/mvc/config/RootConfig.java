package com.mk.demos.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangChen
 * Created on 2021/4/11 19:55
 * @since 1.0
 */
@Configuration
// 此 RootConfig 配置文件中扫描的class
// basePackages = {"com.mk.demos.spring.mvc.config"}
// 在 web ApplicationContext 中 使用不到 ？
// 需要配置 parent ？
@ComponentScan(basePackages = {"com.mk.demos.spring.mvc.config"})
public class RootConfig {

}
