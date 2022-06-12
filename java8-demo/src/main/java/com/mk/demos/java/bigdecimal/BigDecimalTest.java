package com.mk.demos.java.bigdecimal;

import java.math.BigDecimal;

/**
 * BigDecimal test
 *
 * 比较大小应使用compareTo, 而非equals
 *
 * equals会比较 值 和 精度
 * compareTo 只比较 值
 *
 * @author WangChen
 * Created on 2022/6/12
 * @since 1.0.0
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("3.0");
        BigDecimal b = new BigDecimal("3.00");
        System.out.println(a.equals(b)); // false
        System.out.println(a.compareTo(b)); // 0

    }
}
