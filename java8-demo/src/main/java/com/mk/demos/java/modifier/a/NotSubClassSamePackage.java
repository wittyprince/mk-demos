package com.mk.demos.java.modifier.a;

/**
 * NotSubClassSamePackage
 *
 * @author WangChen
 * Created on 2024/10/23
 * @since 1.0
 */
public class NotSubClassSamePackage {

    public void test() {
        PublicClass publicClass = new PublicClass();
        publicClass.publicMethod();
        publicClass.protectedMethod();
        // 'defaultMethod()' has protected access in 'com.mk.demos.java.modifier.a.PublicClass'
        publicClass.defaultMethod();
        // 'privateMethod()' has private access in 'com.mk.demos.java.modifier.a.PublicClass'
//        publicClass.privateMethod(); // 报错
    }
}
