package com.mk.demos.java.polymorphic;

/**
 * 重载
 *
 * @author WangChen
 * Created on 2022/6/12
 * @since 1.0.0
 */
public class OverloadTest2 {

//    public void m(String s) {
//        System.out.println("String...");
//    }

    public void m(Integer i) {
        System.out.println("Integer...");
    }

    public void m(Object o) {
        System.out.println("Object...");
    }

    public void call() {
        // m(String) 和 m(Integer) 注释掉一个便可以编译通过
        m(null); // 编译通过
    }

    public static void main(String[] args) {
        new OverloadTest2().call();
    }

}
