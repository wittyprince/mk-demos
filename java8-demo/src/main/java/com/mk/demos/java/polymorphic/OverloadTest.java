package com.mk.demos.java.polymorphic;

/**
 * 重载
 *
 * @author WangChen
 * Created on 2022/6/12
 * @since 1.0.0
 */
public class OverloadTest {

    public void m(String s) {

    }

    public void m(Integer i) {

    }

    public void m(Object o) {

    }

    public void call() {
//        m(null); // 编译不通过 Ambiguous method call. Both m(String) and m(Integer)
    }

}
