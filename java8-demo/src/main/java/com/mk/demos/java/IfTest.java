package com.mk.demos.java;

/**
 * IfTest
 *
 * @author WangChen
 * Created on 2024/11/22
 * @since 1.0
 */
public class IfTest {

    public static void main(String[] args) {
        String s = "abc";
        if (s.contains("a")) {
            System.out.println("a");
        } else if (s.contains("b")) {
            System.out.println("b");
        } else if (s.contains("c")) {
            System.out.println("c");
        } else {
            System.out.println("d");
        }
        // a
        // 由于if条件满足，所以不会执行else if条件
    }
}
