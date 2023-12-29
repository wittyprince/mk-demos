package com.mk.demos.demo;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * d
 *
 * @author WangChen
 * Created on 2022/6/17
 * @since
 */
public class Demo<E> {

    /**
     * 一个小区里有n个居民，第一天有k个传染病感染者，感染者需要转运到医院隔离和治疗，
     * 该小区第一天的转运感染者的能力是p个人，
     * 第二天转运能力是p-1人，
     * 第三天转运能力是p-2人，以此类推。
     * 如果感染者当天没有转运出小区，则每一个感染者会在当天午夜12点感染1个人。
     * 请问这个小区需要多少天感染者能清零。用Java/JS/TS/C++语言实现求清零天数函数。
     * 要求：
     * (1) 命名一个合适的函数名称，实现完整的函数
     * (2) 按照你平时的编程习惯，在你认为需要注释处写上相应的注释
     * (3) 代码行数尽可能少，代码运行复杂度尽可能小
     * (4) 写出你实现代码的算法复杂度o(n)
     */

//    final private static LinkedList<Integer> lists = new LinkedList<>();

//    private Integer hospital = 100; // 医院容器
    final private int N = 10; // n个居民
    final private static int K = 5; // k个感染者
    private static Integer p = 2; // 转运能力

//    private Integer days = 0; // 需要多少天感染者能清零

    private int count = K; // 剩余感染人数
    public int getCount(){
        return count;
    }


    private Lock lock = new ReentrantLock();
    private Condition consumer = lock.newCondition();
    private Condition producer = lock.newCondition();
    public void put(/*Integer e*/){
        try {
            lock.lock();
            while (count == Integer.MAX_VALUE){
                System.out.println("put await...");
                producer.await();
            }
//            hospital = hospital + e;
            count = count * 2;
            consumer.signalAll();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void transfer(int e){
        try {
            lock.lock();
            while (count == 0){
                System.out.println("dayNum: " + e);
                consumer.await();
            }
            count = count - e;
            producer.signalAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String [] args){
        Demo<Integer> container = new Demo<>();
        new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                container.put();
                container.transfer(p - i);
            }
        }, "transfer: ").start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int n=K; n<Integer.MAX_VALUE; n++){
//                    container.put(n);
//                }
//            }
//        }, "put: ").start();

    }

}
