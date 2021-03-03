package com.mk.demos.java.concurrent.interview;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 写一个固定容量容器，拥有put和get方法，以及getCount方法
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * @author WangChen
 * Created on 2021/3/2 22:02
 * @since 1.0
 */
public class MyContainer2<E> {

    final private LinkedList<E> lists = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;
    public int getCount(){
        return count;
    }
    public void put(E e) {
        synchronized (lists){
            while (lists.size() == MAX){
                try {
                    lists.wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            lists.add(e);
            count++;
            System.out.println("put " + count);
            lists.notifyAll();
        }
    }

    public E get()  {
        E e = null;
        synchronized (lists){
            while (lists.size() == 0){
                try {
                    lists.wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            e = lists.remove();
            count--;
            System.out.println("get " + count);
            lists.notifyAll();
        }
        return e;
    }

    public static void main(String [] args){
        MyContainer2<String> container2 = new MyContainer2<>();
        for (int i=0; i<10; i++){
            new Thread(()->{
                for (int j=0; j<5; j++){
                    container2.get();
                }
            }, "thread " + i).start();
        }

        for (int m=0; m<2; m++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int n=0; n<10; n++){
                        container2.put("s-" + n);
                    }
                }
            }, "thread " + m).start();
        }
    }


}
