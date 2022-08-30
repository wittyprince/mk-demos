package com.mk.demos.nowcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * *HJ33.整数与IP地址间的转换
 *
 * 描述
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 *
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 *
 * 数据范围：保证输入的是合法的 IP 序列
 *
 * 输入描述：
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 *
 * 输出描述：
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 *
 * @author WangChen
 * Created on 2022/8/30
 * @since 1.0
 */
public class HJ33 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            if (str.contains(".")) {
                ip2Decimal(str);
            } else {
                decimal2Ip(Long.parseLong(str));
            }
        }

    }

    public static void ip2Decimal(String ip) {
        String[] split = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(Integer.parseInt(s)));
            while (binaryString.length() < 8) {
                binaryString.insert(0, "0");
            }
            sb.append(binaryString);
        }
        System.out.println(Long.parseLong(sb.toString(), 2));
    }

    public static void decimal2Ip(long decimal) {
        StringBuilder sb = new StringBuilder();
        StringBuilder binaryString = new StringBuilder(Long.toBinaryString(decimal));
        while (binaryString.length() < 32) {
            binaryString.insert(0, "0");
        }
        for (int i = 0; i < binaryString.length(); i=i+8) {
            String substring = binaryString.substring(i, i + 8);
            sb.append(Integer.parseInt(substring, 2)).append(".");
        }
        System.out.println(sb.substring(0, sb.toString().length() - 1));
    }
}
