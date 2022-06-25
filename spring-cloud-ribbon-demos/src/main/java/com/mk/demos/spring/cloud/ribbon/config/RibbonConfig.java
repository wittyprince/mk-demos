package com.mk.demos.spring.cloud.ribbon.config;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * ribbon config
 *
 * @author WangChen
 * Created on 2022/6/25
 * @since 1.0.0
 */
@Configuration
public class RibbonConfig {


    // 以下代码如果不注释，也可以
//    private String name = "cloud-provider";
//
//    /**
//     * 可以参考 RibbonClientConfiguration 的实现方式
//     * org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration#ribbonClientConfig()
//     */
//    @Bean
//    @ConditionalOnMissingBean
//    public IClientConfig ribbonClientConfig() {
//        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
//        config.loadProperties(this.name);
//        return config;
//    }
//
//    @Bean
//    ServerList<Server> ribbonServerList(IClientConfig config) {
//        ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
//        serverList.initWithNiwsConfig(config);
//        return serverList;
//    }
}
