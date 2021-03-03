package com.mk.demos.java.concurrent.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author WangChen
 * Created on 2021/3/3 13:58
 * @since 1.0
 */
public class TicketSeller2 {

    static Queue<String> tickets = new ConcurrentLinkedQueue<>();
    static {
        for (int i=0; i<1000; i++){
            tickets.add("" + i);
        }
    }

    public static void main(String [] args){
        for (int i=0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String poll = tickets.poll();
                        if (poll == null){
                            break;
                        }else {
                            System.out.println("销售了--" + poll);
                        }

                    }
                }
            }).start();
        }
    }
}
