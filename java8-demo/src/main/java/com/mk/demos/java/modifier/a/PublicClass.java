package com.mk.demos.java.modifier.a;

/**
 * PublicClass
 *
 * @author WangChen
 * Created on 2024/10/23
 * @since 1.0
 */
public class PublicClass {

    public void publicMethod(){
        System.out.println("publicMethod");
    }

    protected void protectedMethod(){
        System.out.println("protectedMethod");
    }

    void defaultMethod(){
        System.out.println("defaultMethod");
    }

    private void privateMethod(){
        System.out.println("privateMethod");
    }

}