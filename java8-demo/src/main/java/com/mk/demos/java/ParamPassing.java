package com.mk.demos.java;

/**
 * 参数调用
 *
 * @author WangChen
 * Created on 2021/2/25 20:19
 * @since 1.0
 */
public class ParamPassing {

    private static int intStatic = 222;
    private static String stringStatic = "old string";
    private static StringBuilder stringBuilderStatic = new StringBuilder("old stringBuilder");

    public static void main(String [] args){
        method(intStatic);
        method(stringStatic);
        method(stringBuilderStatic, stringBuilderStatic);

        System.out.println(intStatic);//222
        method();

        System.out.println(intStatic);//888

        System.out.println(stringStatic);//old string

        System.out.println(stringBuilderStatic);//old stringBuilder.method.first-method.second-
    }

    public static void method(int intStatic){
        intStatic = 777;
    }

    public static void method(){
        intStatic = 888;
    }

    public static void method(String stringStatic){
        stringStatic = "new string";
    }

    public static void method(StringBuilder stringBuilderStatic1, StringBuilder stringBuilderStatic2){
        stringBuilderStatic1.append(".method.first-");
        stringBuilderStatic2.append("method.second-");

        stringBuilderStatic1 = new StringBuilder("new stringBuilder");
        stringBuilderStatic1.append("new method`s append");
    }
}
