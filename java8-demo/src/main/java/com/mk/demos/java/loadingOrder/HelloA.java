package com.mk.demos.java.loadingOrder;

/**
 * @author WangChen
 * Created on 2020/4/10 20:36
 * @since
 */
public class HelloA {
    public HelloA(){//构造函数
        System.out.println("A的构造函数");
    }
    {//构造代码块
        System.out.println("A的构造代码块");
    }
    static {//静态代码块
        System.out.println("A的静态代码块");
    }
}
