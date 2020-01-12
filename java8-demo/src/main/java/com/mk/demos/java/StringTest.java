package com.mk.demos.java;

/**
 * string test
 *
 * @author WangChen
 * Created on 2020/1/11 17:04
 * @since 1.0
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        System.out.println(s1 == s2); // true a 被维护在字符串常量池String Table(a pool of String)

        String s3 = new String("a"); // 会创建两个对象, ①分配在heap上的对象, ②常量池中的"a"(如果不存在)
        String s4 = new String("a");
        System.out.println("s3 == s4:" + s3 == s4); // false s3 == s4: 没有打印出来, 注意 +与== 的优先级
        System.out.print("s1 == s3:" + true); // 打印的结果是 s1 == s3:true
        System.out.println(s1 == s3); // false

        String s5 = s3.intern();
        System.out.println(s3 == s1); // false s3指向对象地址并没有改变
        System.out.println(s5 == s1); // true s5指向的常量池中的"a"

        System.out.println("----------------------");
        // String concatenation is implemented through the StringBuilder(or StringBuffer) class and its append method.
        // String conversions are implemented through the method toString
        String ss1 = "a" + "a";
        String ss2 = "aa";
        System.out.println(ss1 == ss2);// true
        String ss3 = "a" + new String("b");
        System.out.println("----------------------");
        String ss3intern = ss3.intern();
        String ss4 = "ab";
        System.out.println("ss3intern:" + (ss3 == ss3intern));// false
        System.out.println(ss3 == ss4);// true
        System.out.println(ss3intern == ss4);// true

        System.out.println("--2--------------------");
        String sss3 = "c" + new String("d");
        String sss4 = "cd";
        String sss3intern = ss3.intern();
        System.out.println("sss3intern:" + sss3 == sss3intern);// false
        System.out.println(sss3 == sss4);// false
        System.out.println(sss3intern == sss4);// true

        System.out.println("--3--------------------");

        String ss5 = new String("c") + new String("d");//
        String ss6 = "cd";
        String ss5intern = ss5.intern();
        System.out.println("aa:"+ (ss5 == ss6));// false
        System.out.println(ss5intern == ss6);// true
        System.out.println(ss5intern == ss5);// false
    }


}
