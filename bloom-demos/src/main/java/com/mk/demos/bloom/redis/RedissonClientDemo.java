package com.mk.demos.bloom.redis;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * redisson client
 *
 * @author WangChen
 * Created on 2022/2/18
 * @since 0.1
 */
public class RedissonClientDemo {

    public static void main(String[] args) {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:16379");
        RedissonClient redisson = Redisson.create(config);

        RBloomFilter<String> bloomFilter = redisson.getBloomFilter("user");
        // 初始化布隆过滤器，预计统计元素数量为55000000，期望误差率为0.03
        bloomFilter.tryInit(100_000L, 0.03);
        bloomFilter.add("Tom");
        bloomFilter.add("Jack");
        System.out.println(bloomFilter.count());   //2
        System.out.println(bloomFilter.contains("Tom"));  //true
        System.out.println(bloomFilter.contains("Linda"));  //false


        System.out.println(bloomFilter.getName());
//        boolean delete = bloomFilter.delete();
//        System.out.println(delete);
    }
}
