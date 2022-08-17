package com.mk.demos.java.thread;

/**
 * thread test
 *
 * @author WangChen
 * Created on 2022/8/17
 * @since 1.0
 */
public class ThreadTest {

    public static void main(String[] args) {
        System.out.println("1...");

        new Thread(() -> {
            System.out.println("000");
            // 子线程异常，主线程不会中断运行
            throw new RuntimeException("a");
        }).start();
        System.out.println("2...");
    }
}
