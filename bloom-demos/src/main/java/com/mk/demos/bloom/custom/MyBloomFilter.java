package com.mk.demos.bloom.custom;

import java.util.BitSet;

/**
 * 自定义 bloom filter
 *
 * @author WangChen
 * Created on 2022/2/17
 * @since 0.1
 */
public class MyBloomFilter {

    /**
     * 一个长度为10 亿的比特位: 256 << 22
     */
    private static final int DEFAULT_SIZE = 1 << 10;

    /**
     * 为了降低错误率，使用加法hash算法，所以定义一个8个元素的质数数组 {3, 5, 7, 11, 13, 31, 37, 61};
     */
    private static final int[] seeds = {5, 7};

    /**
     * 相当于构建 8 个不同的hash算法
     */
    private static HashFunction[] functions = new HashFunction[seeds.length];

    /**
     * 初始化布隆过滤器的 bitmap
     */
    private static BitSet bitset = new BitSet(DEFAULT_SIZE);

    /**
     * 添加数据
     *
     * @param value 需要加入的值
     */
    public static void add(String value) {
        if (value != null) {
            for (HashFunction f : functions) {
                //计算 hash 值并修改 bitmap 中相应位置为 true
                bitset.set(f.hash(value), true);
            }
        }
    }

    /**
     * 判断相应元素是否存在
     * @param value 需要判断的元素
     * @return 结果
     */
    public static boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (HashFunction f : functions) {
            ret = bitset.get(f.hash(value));
            //一个 hash 函数返回 false 则跳出循环
            if (!ret) {
                break;
            }
        }
        return ret;
    }

    /**
     * 模拟用户是不是会员，或用户在不在线。。。
     */
    public static void main(String[] args) {

        for (int i = 0; i < seeds.length; i++) {
            functions[i] = new HashFunction(DEFAULT_SIZE, seeds[i]);
        }

        // 添加1亿数据 100000000
//        for (int i = 0; i < 1000; i++) {
//            add(String.valueOf(i));
//        }
        String s1 = "AB";
        add(s1);
        System.out.println(contains(s1));   // true
        System.out.println(s1 + ": " + bitset);

        String s2 = "st";
        add(s2);
        System.out.println(contains(s2));   // true
        System.out.println(s2 + ": " + bitset);

        String s3 = "U`";
        System.out.println(contains(s3));  //false
    }
}
