package com.mk.demos.java.loadingOrder;

/**
 * 继承时，按照如下顺序执行:
 * 1. 执行父类的静态代码块，并初始化父类静态成员变量
 * 2. 执行子类的静态代码块，并初始化子类静态成员变量
 * 3. 执行父类的构造代码块，执行父类的构造函数，并初始化父类普通成员变量
 * 4. 执行子类的构造代码块， 执行子类的构造函数，并初始化子类普通成员变量
 *
 * @author WangChen
 * Created on 2020/4/10 20:36
 * @since
 */
public class HelloB extends HelloA{
    public HelloB(){//构造函数
        System.out.println("B的构造函数");
    }
    {//构造代码块
        System.out.println("B的构造代码块");
    }
    static {//静态代码块
        System.out.println("B的静态代码块");
    }
    public static void main(String[] args) {
        HelloB b=new HelloB();

        /**
         * 运行main方法后执行顺序
         * A的静态代码块
         * B的静态代码块
         * A的构造代码块
         * A的构造函数
         * B的构造代码块
         * B的构造函数
         */
    }
}
