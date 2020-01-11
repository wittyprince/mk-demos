package com.mk.demos.java;

/**
 * 基本类型
 *
 * @author WangChen
 * Created on 2020/1/5 18:15
 * @since 1.0
 */
public class PrimitiveTypeTest {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);//0x7fff_ffff = 2147483647

        byte a = 12; // 编译通过, int向下隐式转换为byte
        short b = 12;
        int c = 128;
        long d = 12;
//        byte e = 128; // 编译出错, 128超出byte取值范围, 不能隐式转换
        byte f = (byte) 128; // 编译通过
        System.out.println("f=" + f);// -128
//        short g = Short.MAX_VALUE + 1; // 2^15 -1 = 32767, 编译出错, 超出范围
//        byte h = c; // 编译报错, c已确定类型, 不能向下隐式转换
        byte i = (byte) c; // 编译通过, 虽然会128溢出, 但是有强制转换
        System.out.println("i=" + i);
        long j = c; // 编译通过, 可以向上隐式转换
//        long k = 12345678901;//报错 因为超过了int的范围又不加L、l(小写)
        long k2 = Integer.MAX_VALUE + 1;//编译通过，默认为int运算，溢出丢弃
        System.out.println("k2=" + k2);
        short m = 1;
//        m = m + (short) 1; // 编译出错 require short, found int
        m +=1; // 编译通过, 相当于 s4 = (short)(s4 + 1);
        short n = 3;
        // 两个数相加, 默认会先转换为int或比int大的范围数,如long, double, 所以运算结束后需强制转换为short
//        short p = m + n; // 编译出错 require short, found int, 需改为 (short) (s4 + r4)
        short q = 3;
//        q = q + 4.7; // 编译出错 require short, found double
        q += 4.7;
        System.out.println(q); // 7    E1 op= E2 is equivalent to E1 = (T)((E1) op (E2))
        int a3 = 1;
        long b3 = 2;
//        int c3 = a3 + b3; // 编译出错 require int, found long
        long d3 = a3 + b3; // 编译通过
        a3+= b3;
        System.out.println(a3);

        float s = 1.5F;
        // 1.5虽然在float取值范围内，但是1.5默认是double双精度, 隐式转换为float单精度会丢失精度
//        float s2 = 1.5; // 编译出错, require float, found double,
        float s3 = (float) 1.5;
        double t = s;
        double u = 1111111;
        double u2 = 123.12;
        float v = 123;
        float w = 0.9f;
        float w2 = 1f;
        float w3 = w2 - w;
        System.out.println("w3=" + (1-0.9f));
        double dd1 = 1;
        double dd2 = 0.9;
        double dd3 = dd1 - dd2;
        System.out.println("dd3=" + dd3);

        int a4 = new Integer(1);
        Integer a5 = new Integer(1);

    }
}
