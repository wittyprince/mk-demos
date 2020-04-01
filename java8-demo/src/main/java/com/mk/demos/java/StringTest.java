package com.mk.demos.java;

/**
 * string test
 *
 * @author WangChen
 * Created on 2020/1/11 17:04
 * @since 1.0
 */
public class StringTest {

    public static void main(String[] args) throws InterruptedException {
        // 两个字符串
        String s1 = "a";
        String s2 = "a";
        System.out.println(s1 == s2); // true a 被维护在字符串常量池String Table(a pool of String)

        // 两个String对象
        String s3 = new String("a"); // 会创建两个对象, ①分配在heap上的对象, ②常量池中的"a"(如果不存在)
        String s4 = new String("a");
        System.out.println("s3 == s4:" + (s3 == s4)); // false s3 == s4: 没有打印出来, 注意 +与== 的优先级
        System.out.println("s1 == s3:" + (s1 == s3)); // false

        //String.intern()方法
        String s5 = s3.intern();//a string that has the same contents as this string, but is guaranteed to be from a pool of unique strings.
        System.out.println(s3 == s1); // false s3指向对象地址并没有改变
        System.out.println("s5 == s1:" + (s5 == s1)); // true s5指向的常量池中的"a"

        // 字符串拼接
        System.out.println("--0--------------------");
        // String concatenation is implemented through the StringBuilder(or StringBuffer) class and its append method.
        // String conversions are implemented through the method toString
        String t1 = "a" + "a";
        String t2 = "aa";
        System.out.println("t1 == t2:" + (t1 == t2));// true

        System.out.println("--1--------------------");
        String ss1 = "a" + new String("b");
        String ss2 = "ab";
        System.out.println("ss1 == ss2:" + (ss1 == ss2));// false
        String ss1intern = ss1.intern();
        System.out.println("ss1intern:" + (ss1 == ss1intern));// false
        System.out.println(ss1intern == ss2);// true

        System.out.println("--2--------------------");
        String tt1 = "c" + new String("d");
        String tt2 = "cd";
        String tt1intern = tt1.intern();
        System.out.println("tt1intern:" + (tt1 == tt1intern));// false
        System.out.println(tt1 == tt2);// false
        System.out.println(tt1intern == tt2);// true

        System.out.println("--3--------------------");

        String ss5 = new String("c") + new String("d");//
        String ss6 = "cd";
        String ss5intern = ss5.intern();
        System.out.println(ss5intern == ss5);// false
        System.out.println("aa:"+ (ss5 == ss6));// false
        System.out.println(ss5intern == ss6);// true

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                String s = new String("ss");
                System.out.println("r1:" + (s.intern() == s));
                System.out.println("r11:" + (s.intern() == s));
            }
        };

        Thread t0 = new Thread(r1);
        t0.start();

        Thread.sleep(5000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = new String("ss");
                System.out.println("r2:" + (s.intern() == s));
            }
        }).start();

        Thread.sleep(5000);


        String a1 = new StringBuilder("Cattie").toString();// toString() 返回的是 return new String(value, 0, count);
        System.out.println("a1:" + (a1.intern() == a1)); // false
        System.out.println("a1::"+ (a1 == "Cattie")); // false

        String a2 = new StringBuilder("Cattie").append(" & Doggie").toString();
        System.out.println("a2:" + (a2.intern() == a2)); // true why?
        System.out.println("a2::"+ (a2 == "Cattie & Doggie")); // true another why?

        // 与上一段代码相比，只不过是输出语句顺序不同，但是结果却也不同
        String a3 = new StringBuilder("Cattie").append(" & Doggie").toString();
        System.out.println("a3::"+ (a3 == "Cattie & Doggie")); // false
        System.out.println("a3:" + (a3.intern() == a3)); // false why?
    }


}
