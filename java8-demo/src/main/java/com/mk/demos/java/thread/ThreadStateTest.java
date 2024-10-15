package com.mk.demos.java.thread;

/**
 * ThreadStateTest
 *
 * @author WangChen
 * Created on 2024/10/15
 * @since 1.0
 */
public class ThreadStateTest {

    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                System.out.println("t1 is running...");
            }
        };
        System.out.println(t1.getState()); // NEW

        t1.start();
        // 注意, RUNNABLE状态表示线程可以运行, 但不一定正在运行
        System.out.println(t1.getState()); // RUNNABLE

    }
}
