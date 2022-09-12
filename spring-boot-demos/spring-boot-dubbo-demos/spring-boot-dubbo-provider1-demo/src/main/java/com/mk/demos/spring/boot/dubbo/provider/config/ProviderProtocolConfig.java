package com.mk.demos.spring.boot.dubbo.provider.config;

import org.apache.dubbo.config.ProtocolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * config
 *
 * @author WangChen
 * Created on 2022/9/12
 * @since 1.0
 */
//@Configuration
public class ProviderProtocolConfig {

    @Bean // #2
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("rest");
        protocolConfig.setPort(8080);
        protocolConfig.setServer("netty");
        return protocolConfig;
    }
}
