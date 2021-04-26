package com.mk.demos.spring.aop;

/**
 * 直接调用
 *
 * @author WangChen
 * Created on 2021/4/26 19:29
 * @since
 */
public class DirectCall {
    public static void main(String[] args) {

        Pojo pojo = new SimplePojo();

        // this is a direct method call on the 'pojo' reference
        pojo.foo();
    }
}
