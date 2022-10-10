package com.mk.demos.spring.boot.rabbitmq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * send config
 *
 * @author WangChen
 * Created on 2022/10/10
 * @since 1.0
 */
@Configuration
public class SendConfig {

    public static final String DIRECT_QUEUE_1 = "direct.queue.1"; // "direct.queue.1";
    public static final String DIRECT_QUEUE_2 = "direct.queue.2"; // "direct.queue.2";
    public static final String DIRECT_EXCHANGE = "direct.exchange";
    public static final String DIRECT_ROUTE_KEY_1 = "direct.route.key.1";
    public static final String DIRECT_ROUTE_KEY_2 = "direct.route.key.2";

    @Bean
    public Queue directQueue1() {
        return new Queue(DIRECT_QUEUE_1);
    }

    @Bean
    public Queue directQueue2() {
        return new Queue(DIRECT_QUEUE_2);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with(DIRECT_ROUTE_KEY_1);
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with(DIRECT_ROUTE_KEY_2);
    }
}
