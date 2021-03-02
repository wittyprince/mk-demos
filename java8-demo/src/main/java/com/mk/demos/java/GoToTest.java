package com.mk.demos.java;

/**
 * java中goto使用
 *
 * @author WangChen
 * Created on 2021/3/2 20:08
 * @since 1.0
 */
public class GoToTest {

    public static void main(String [] args){
        int i = 0;
        label:
        for (int j = 0; j < 10; j++) {
            for (i = 1; i < 10; i++) {
                System.out.println(i);
                if (i == 5) {
                    //这样就可以跳出整个大循环了,break label 也会中断所有循环，并回到 label 处，但并不重
                    //新进入循环。也就是说，它实际是完全中止了两个循环。
                    break label;
                }
                if(i==4){
                    continue label;
                }
            }
        }
    }
}
