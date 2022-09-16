package com.mk.demos.java.jstring;

/**
 * string.length()
 *
 * @author WangChen
 * Created on 2022/9/16
 * @since 1.0
 */
public class StringLength {

    public static void main(String[] args) {
        String s1 = "\uD834\uDD1E";
        String s2 = "\uD834\uDD1E";
        System.out.println(s1); // 𝄞
        System.out.println(s1.length()); // 2
        System.out.println(s1.codePointCount(0, s1.length()/* - 1 ??? */)); // 1
    }
}
