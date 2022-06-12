package com.mk.demos.java.radix;

/**
 * java 中 各进制间转换方法
 *
 * @author WangChen
 * Created on 2022/6/12
 * @since 1.0.0
 */
public class RadixConversion {

    public static void main(String[] args) {

        Integer decimal = 10;
        // 十进制 转 二进制
        String binaryString = Integer.toBinaryString(decimal);
        System.out.println("binaryString: " + binaryString);

        // 十进制 转 十六进制
        String hexString = Integer.toHexString(decimal);
        System.out.println("hexString: " + hexString);


        // ----------------------------------------
        // 二进制 转 十进制
        Integer integer2 = Integer.valueOf("1111111", 2);
        System.out.println("integer2: " + integer2);

        // 十六进制 转 十进制
        Integer integer16 = Integer.valueOf("1a", 16);
        System.out.println("integer16: " + integer16);

        // -----------------------------------------
        // 科学计数法E
        double d = 1e-2;
        System.out.println("d: " + d);

        // 指数表示
        double pow = Math.pow(2, 23);
        System.out.println("pow: " + pow);


        double pow2 = Math.pow(2, 52);
        System.out.println("pow: " + pow2);

        System.out.println(Math.pow(10, 16));
    }
}
