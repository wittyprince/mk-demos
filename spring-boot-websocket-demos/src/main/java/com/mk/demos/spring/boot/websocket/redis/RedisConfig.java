package com.mk.demos.spring.boot.websocket.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis config
 *
 * @author WangChen
 * Created on 2022/9/4
 * @since 1.0
 */
@Configuration
public class RedisConfig {

    /**
     * RedisTemplate<Object, Object>
     * 这个Bean使用JdkSerializationRedisSerializer进行序列化，
     * 即key, value需要实现Serializable接口，redis数据格式比较难懂
     *
     *
     * Spring配置的两个RedisTemplate都不太方便使用，
     * 所以可以配置一个RedisTemplate<String,Object> 的Bean，
     * key使用String即可(包括Redis Hash 的key)，
     * value存取Redis时默认使用Json格式转换。如下
     */
    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> template(RedisConnectionFactory factory) {
        // 创建RedisTemplate<String, Object>对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 配置连接工厂
        template.setConnectionFactory(factory);
        // 定义Jackson2JsonRedisSerializer序列化对象
        Jackson2JsonRedisSerializer<Object> jacksonSerial = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会报异常
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSerial.setObjectMapper(om);
        StringRedisSerializer stringSerial = new StringRedisSerializer();
        // redis key 序列化方式使用stringSerial
        template.setKeySerializer(stringSerial);
        // redis value 序列化方式使用jackson
        template.setValueSerializer(jacksonSerial);
        // redis hash key 序列化方式使用stringSerial
        template.setHashKeySerializer(stringSerial);
        // redis hash value 序列化方式使用jackson
        template.setHashValueSerializer(jacksonSerial);
        template.afterPropertiesSet();
        return template;
    }


}
