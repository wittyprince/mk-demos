package com.mk.demos.java.loadingOrder;

/**
 * InitialOrderTest
 *
 * @author WangChen
 * Created on 2024/11/1
 * @since 1.0
 */
public class InitialOrderTest {
    /* 静态变量 */
    public static String staticField = "静态变量";
    /* 变量 */
    public String field = "变量";
    /* 静态初始化块 */
    static {
        System.out.println( staticField );
        System.out.println( "静态初始化块" );
    }
    /* 初始化块 */
    {
        System.out.println( field );
        System.out.println( "初始化块" );
    }
    /* 构造器 */
    public InitialOrderTest() {
        System.out.println("构造器");
    }


    public static void main(String[] args) {
        new InitialOrderTest();
        //1.静态变量
        //2.静态初始化块
        //3.变量
        //4.初始化块
        //5.构造器
    }
}
