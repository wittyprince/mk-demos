package com.mk.demos.java.concurrent.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 *
 * @author WangChen
 * Created on 2021/3/3 11:13
 * @since 1.0
 */
public class TicketSeller {

    static List<String> tickets = new ArrayList<>(1000);
    static {
        for (int i=0; i<1000; i++){
            tickets.add("" + i);
        }
    }

    public static void main(String [] args){
        for (int i=0; i<10; i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        synchronized (tickets){
                            if (tickets.size() <= 0){
                                break ;
                            }
                            try {
                                TimeUnit.MICROSECONDS.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            String removed = tickets.remove(0);
                            System.out.println("销售了--" + removed);
                        }

                    }
                }
            });
            t.start();
        }
    }
}
