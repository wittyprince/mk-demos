package com.mk.demos.java.concurrent.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个容器，提供两个方法 add, size
 * 有两个线程，线程1添加10个元素到容器中，线程2实现监控元素个数，当个数到5个时，线程2给出提示并结束
  * @author WangChen
 * Created on 2021/3/2 21:09
 * @since 1.0
 */
public class MyContainer1 {

    List<Object> list = new ArrayList<>();

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }


    public static void main(String [] args){

        MyContainer1 container1 = new MyContainer1();

        // 方法一：wait/notifyAll
        /*final Object lock = new Object();
        new Thread(
                () -> {
                    synchronized (lock){
                        System.out.println("t2 启动...");
                        if (container1.size() != 5){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("t2 结束");
                        lock.notifyAll();
                    }
                }
        ).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        synchronized (lock){
                            for (int i = 0; i < 10; i++){
                                System.out.println("t1..." + i);
                                container1.add(new Object());
                                if (container1.size() == 5){
                                    lock.notify();
                                    try {
                                        lock.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                try {
                                    TimeUnit.SECONDS.sleep(1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
        ).start();*/

        // 方法二：CountDownLatch/CyclicBarrier/Semaphore
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() ->{
            for (int i = 0; i < 10; i++){
                container1.add(new Object());
                System.out.println("t1..." + i);
                if (container1.size() == 5){
                    countDownLatch.countDown();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            System.out.println("t2 启动");
            if(container1.size() != 5){
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 停止");
        }).start();

    }




}
