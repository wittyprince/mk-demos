package com.mk.demos.java.jclass.field;

/**
 * @author WangChen
 * Created on 2021/8/8 13:15
 * @since
 */
class A {
    private String inner = "time flies.";

    public void call() {
        System.out.println("hello world.");
    }

    public String getInner() {
        return inner;
    }
}
