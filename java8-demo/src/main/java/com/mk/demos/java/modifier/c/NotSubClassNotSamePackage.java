package com.mk.demos.java.modifier.c;

import com.mk.demos.java.modifier.a.PublicClass;

/**
 * NotSubClassNotSamePackage
 *
 * @author WangChen
 * Created on 2024/10/23
 * @since 1.0
 */
public class NotSubClassNotSamePackage {

    public void test() {
        PublicClass publicClass = new PublicClass();
        publicClass.publicMethod();
//        publicClass.protectedMethod(); // 报错
        // 'defaultMethod()' has protected access in 'com.mk.demos.java.modifier.a.PublicClass'
//        publicClass.defaultMethod(); // 报错
        // 'privateMethod()' has private access in 'com.mk.demos.java.modifier.a.PublicClass'
//        publicClass.privateMethod(); // 报错

    }

}
