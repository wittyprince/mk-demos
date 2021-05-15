package com.mk.demos.java;

/**
 * java是传值还是传址
 *
 * The Java Spec says that everything in Java is pass-by-value.
 * There is no such thing as "pass-by-reference" in Java.
 * Java规范中说在Java中所有的都是传值，不存在传址(传引用)的情况
 *
 * 基本数据类型、字符串 是 传值    ×
 * 引用类型 是 传址                ×
 *
 * 其实java中传址应该是pass by reference 而不是pass by address,
 * 所以这里就好理解什么类型是传值还是传址了
 *
 * @author WangChen
 * Created on 2020/12/19 21:49
 * @since 1.0
 */
public class PassValueOrPassAddress {
    public static void main(String [] args){
        String a = "x";
        String b = a;
        a = "y";
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        Dog d1 = new Dog("d1");
        Dog d2 = d1;
        d1.setName("dd1");
        System.out.println(d2.getName());//dd1

        Dog g1 = new Dog("g1");
        foo(g1);

        System.out.println("g1 name = " + g1.getName());

    }

    public static void foo(Dog someDog) {
        someDog.setName("Max");     // AAA
        System.out.println("someDog1:" + someDog.getName());
        someDog = new Dog("Fifi");  // BBB
        someDog.setName("Rowlf");   // CCC
        System.out.println("someDog2:" + someDog.getName());
    }
}
class Dog{
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
