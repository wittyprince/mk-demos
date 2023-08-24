package com.mk.demos.bloom.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * guava bloom filter
 *
 * @author WangChen
 * Created on 2022/2/18
 * @since 0.1
 */
public class GuavaBloomFilterDemo {

    public static void main(String[] args) {
        //后边两个参数：预计包含的数据量，和允许的误差值
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 100_000, 0.01);
        for (int i = 0; i < 100000; i++) {
            bloomFilter.put(i);
        }
        System.out.println(bloomFilter.mightContain(1));
        System.out.println(bloomFilter.mightContain(2));
        System.out.println(bloomFilter.mightContain(3));
        System.out.println(bloomFilter.mightContain(100001));

        //
        // bloomFilter.writeTo();
    }
}
