package com.mk.demos.java.modifier.b;

import com.mk.demos.java.modifier.a.PublicClass;

/**
 * SubClass
 *
 * @author WangChen
 * Created on 2024/10/23
 * @since 1.0
 */
public class SubClassNotSamePackage extends PublicClass {

    public void test() {
        publicMethod();
        protectedMethod();
        // 'defaultMethod()' is not public in 'com.mk.demos.java.modifier.a.PublicClass'. Cannot be accessed from outside package
//        defaultMethod(); // 报错
//        privateMethod(); // 报错
    }
}
