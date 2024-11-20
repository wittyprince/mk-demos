package com.mk.demos.java.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * synchronized test
 *
 * synchronized(this) 和 synchronized方法都是锁定当前对象
 * @author WangChen
 * Created on 2019/4/29 11:27
 * @since
 */
public class SynchronizedTest {

    private int count = 0;
    private Object obj = new Object();

    public void testSync1(){
        synchronized (obj){
            System.out.println(Thread.currentThread().getName() + ",count = " + count++);
        }
    }

    public void testSync2(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + ",count = " + count++);
        }
    }

    public synchronized void testSync3(){
        System.out.println(Thread.currentThread().getName() + ",count = " + count++);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void testSync5(){
        System.out.println(Thread.currentThread().getName() + ",count = " + 1);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void testSync4(){
        synchronized (SynchronizedTest.class){
            System.out.println(Thread.currentThread().getName() + ",count = " + count++);
        }
    }

    public static void main(String[] args){
        SynchronizedTest test1 = new SynchronizedTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.testSync2();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.testSync2();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.testSync4();
            }
        }).start();
    }
}
