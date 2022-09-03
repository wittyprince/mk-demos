package com.mk.demos.spring.boot.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * WebSocket config
 *
 * 开启WebSocket支持
 *
 * @author WangChen
 * Created on 2022/9/3
 * @since 1.0
 */
@Configuration
public class WebSocketConfig {

    /**
     * 注意：ServerEndpointExporter一定要注入，
     * 这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint；
     * 如果使用独立的servlet容器，而不是直接使用springboot的内置容器，就不要注入ServerEndpointExporter，
     * 因为它将由容器自己提供和管理。
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
