package com.mk.demos.bloom;

/**
 * 自定义 hash 函数
 *
 * @author WangChen
 * Created on 2022/2/17
 * @since 0.1
 */
public class MyHash {

    /**
     * ref: String#hashCode
     */
    public static int hash31(String str) {
        char[] value = str.toCharArray();
        int h = 0;
        if (value.length > 0) {
            for (char c : value) {
                h = 31 * h + c;
            }
        }
        return h;
    }

    public static int hash13(String str) {
        char[] value = str.toCharArray();
        int h = 0;
        if (value.length > 0) {
            for (char c : value) {
                h = 13 * h + c;
            }
        }
        return h;
    }

    public static int hash11(String str) {
        char[] value = str.toCharArray();
        int h = 0;
        if (value.length > 0) {
            for (char c : value) {
                h = 11 * h + c;
            }
        }
        return h;
    }

    public static int hash7(String str) {
        char[] value = str.toCharArray();
        int h = 0;
        if (value.length > 0) {
            for (char c : value) {
                h = 7 * h + c;
            }
        }
        return h;
    }

    public static int hash5(String str) {
        char[] value = str.toCharArray();
        int h = 0;
        if (value.length > 0) {
            for (char c : value) {
                h = 5 * h + c;
            }
        }
        return h;
    }

    public static int hash3(String str) {
        char[] value = str.toCharArray();
        int h = 0;
        if (value.length > 0) {
            for (char c : value) {
                h = 3 * h + c;
            }
        }
        return h;
    }

    public static void main(String[] args) {

//        System.out.println(hash31("ok"));
//        System.out.println(hash31("pL"));
//
//        System.out.println(hash7("ok"));
//        System.out.println(hash7("pd"));

//        System.out.println(" !3: " + hash3("#$"));
//        System.out.println(" !5: " + hash5("#$"));
//        System.out.println(" !7: " + hash7("#$"));
//        System.out.println(" !11: " + hash11("#$"));
//        System.out.println(" !13: " + hash13("#$"));

//        System.out.println("ab3: " + hash3("AB"));
        System.out.println("AB5: " + hash5("AB"));
        System.out.println("AB7: " + hash7("AB"));
//        System.out.println("ab11: " + hash11("AB"));
//        System.out.println("ab13: " + hash13("AB"));

//        System.out.println("st3: " + hash3("st"));
        System.out.println("st5: " + hash5("st"));
        System.out.println("st7: " + hash7("st"));
//        System.out.println("st11: " + hash11("st"));

        System.out.println("U`5: " + hash5("U`"));
        System.out.println("U`7: " + hash7("U`"));

//        System.out.println(1023 & hash31("ab"));
//        System.out.println(1023 & hash31("ba"));
//        System.out.println(1023 & hash7("bc"));

//        String s1 = "Ab"; // Ab <=> BC
//        String s2 = "BC"; // Ab <=> BC
//        System.out.println(hash(s1) == hash(s2));
//
//        System.out.println(1 << 8);

//        String s = "a";
////        System.out.println(hash(s));
////        System.out.println(s.charAt(0));
//        byte[] bytes = s.getBytes();
//        for (byte b : bytes) {
//            System.out.println(b);
//        }
//        System.out.println(Character.toString((char) 21));
//        System.out.println(Character.toString((char) 34));
//        System.out.println((byte) '"');


    }
}
