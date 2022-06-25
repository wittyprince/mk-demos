package com.mk.demos.spring.cloud.ribbon;

import com.mk.demos.spring.cloud.ribbon.config.RibbonConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.naming.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * run
 *
 * @author WangChen
 * Created on 2022/6/24
 * @since 1.0.0
 */
@SpringBootApplication
//@EnableDiscoveryClient
//调用名称"cloud-provider"服务的时候，使用RibbonConfig配置
@RibbonClient(name="cloud-provider", configuration= RibbonConfig.class)
@Slf4j
public class RibbonRun {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RibbonRun.class, args);

//        Object discoveryClient = context.getBean("ribbonClientConfig");
//        System.out.println("discoveryClient: {}" + discoveryClient);
    }



}
