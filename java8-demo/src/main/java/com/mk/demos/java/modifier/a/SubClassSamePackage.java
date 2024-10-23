package com.mk.demos.java.modifier.a;

/**
 * SubClass1
 *
 * @author WangChen
 * Created on 2024/10/23
 * @since 1.0
 */
public class SubClassSamePackage extends PublicClass {

        public void test() {
            publicMethod();
            protectedMethod();
            // 'defaultMethod()' is not public in 'com.mk.demos.java.modifier.a.PublicClass'. Cannot be accessed from outside package
            defaultMethod();
//            privateMethod(); // 报错
        }
}
