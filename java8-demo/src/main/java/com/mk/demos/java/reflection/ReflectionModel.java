package com.mk.demos.java.reflection;

/**
 * Reflection 测试 model实体类
 * @author WangChen
 * Created on 2021/1/23 10:52
 * @since 1.0
 */
class ReflectionModel {
    public int age;
    private String name;
    public static String staticField;
    private static final int staticFinalField = 0;

    static {
        System.out.println("this is Class T`s static block!");
    }

    {
        System.out.println("this is Class T`s (dynamic) block!");
    }

    public ReflectionModel() {
    }

    private ReflectionModel(String name) {
        this.name = name;
    }

    public ReflectionModel(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String publicMethod(String str) {
        System.out.println("publicMethod..." + str);
        return "publicMethod";
    }

    public static String publicStaticMethod() {
        System.out.println("publicStaticMethod...");
        return "publicStaticMethod";
    }

    private String privateMethod(String str) {
        System.out.println("privateMethod..." + str);
        return "privateMethod";
    }

    private static void privateStaticMethod() {
        System.out.println("privateStaticMethod...");
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
