package com.mk.demos.java;

/**
 * LabelForTest
 *
 * @author WangChen
 * Created on 2024/11/22
 * @since 1.0
 */
public class LabelForTest {

    public static void main(String[] args) {

        outer:
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i);
            inner:
            for (int j = 0; j < 5; j++) {
                System.out.println("j=" + j);
                // continue the outer loop when j == 2
                if (j == 2 && i == 1) {
                    // continue outer 继续i=2外部循环
                    continue outer;
                }
                if (j == 3 && i == 3) {
                    // break the outer loop when j == 3
                    // break outer; // 结束outer外部循环
                    break outer;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        System.out.println("end");
    }
}
