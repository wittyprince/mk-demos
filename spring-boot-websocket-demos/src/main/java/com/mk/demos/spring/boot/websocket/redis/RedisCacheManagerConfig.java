package com.mk.demos.spring.boot.websocket.redis;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

/**
 * RedisCacheManager
 *
 * @author WangChen
 * Created on 2022/9/4
 * @since 1.0
 */
//@Configuration
public class RedisCacheManagerConfig {

    /**
     * Spring支持多种缓存技术：RedisCacheManager、EhCacheCacheManager、GuavaCacheManager等，
     * 使用之前需要配置一个CacheManager的Bean。
     * 配置好之后使用三个注解来缓存数据：@Cacheable，@CachePut 和 @CacheEvict。
     * 这三个注解可以加Service层或Dao层的类名上或方法上(建议加在Service层的方法上)，
     * 加上类上表示所有方法支持该注解的缓存；三注解需要指定Key，以返回值作为value操作缓存服务。
     * 所以，如果加在Dao层，当新增1行数据时，返回数字1，会将1缓存到Redis，而不是缓存新增的数据。
     */

    /**
     * <p>SpringBoot配置redis作为默认缓存工具</p>
     * <p>SpringBoot 2.0 以上版本的配置</p>
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate<String, Object> template) {
        RedisCacheConfiguration defaultCacheConfiguration =
                RedisCacheConfiguration
                        .defaultCacheConfig()
                        // 设置key为String
                        .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(template.getStringSerializer()))
                        // 设置value 为自动转Json的Object
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(template.getValueSerializer()))
                        // 不缓存null
                        .disableCachingNullValues()
                        // 缓存数据保存1小时
                        .entryTtl(Duration.ofHours(1));
        RedisCacheManager redisCacheManager =
                RedisCacheManager.RedisCacheManagerBuilder
                        // Redis 连接工厂
                        .fromConnectionFactory(template.getConnectionFactory())
                        // 缓存配置
                        .cacheDefaults(defaultCacheConfiguration)
                        // 配置同步修改或删除 put/evict
                        .transactionAware()
                        .build();
        return redisCacheManager;
    }
}
