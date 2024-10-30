package com.mk.demos.java.keywords;

/**
 * ContinueTest
 *
 * @author WangChen
 * Created on 2024/10/30
 * @since 1.0
 */
public class ContinueTest {

    public static void main(String[] args) {

        int a = 0;
        for (;;) {
            System.out.println("before continue");
            // 注意 if 的语义块
            if (a++ < 5)
                if (a++ < 5)
                    continue;
            if (a > 10)
                break;
            System.out.println("after continue");
        }


        for (;;) {
            System.out.println("before continue");
            continue;
            // Unreachable statement
            //System.out.println("after continue");
            // 无终止条件, 这里会死循环
        }
    }

}
