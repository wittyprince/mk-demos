package com.mk.demos.java.thread.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * interrupt()
 *
 * isInterrupted()
 *
 * interrupted()
 *
 *
 *
 * @author WangChen
 * Created on 2022/8/12
 * @since 1.0
 */
public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {

        InterruptDemo demo = new InterruptDemo();

        demo.m1();

    }

    /**
     * 约定：
     * 内部中断的线程，如果需要继续执行，则必须重新设置信令状态为true；此时外部调用者才会清楚当前线程已经收到中断信令但是还要继续执行；
     * <p>
     * 什么情况下，线程状态会自动变更为false？
     * <p>
     * 1、线程自动执行完毕后，则状态将会自动置为 false；
     * 2、线程内部使用：Thread.interrupted()方法获取线程状态时，将会自动清除线程状态，使当前线程状态重新更改为false；
     * 3、线程内部如果捕获了，InterruptedException异常，那么此时线程状态也会自动修改为false；
     * <p>
     * 所以，
     * 1、如果是使用Thread.interrupted()来获取线程状态的情况，使用完以后，必须保证线程是正常中断的；如果不能保证，建议使用Thread.currentThread().isInterrupted()来获取线程状态;isInterrupted()方法只获取线程状态，不会更改线程状态；
     * 2、对于线程内使用try catch 捕获了InterruptedException异常的情况，则捕获完以后，一定要做相关操作，而不要只捕获异常，但是不处理该中断信令；
     * 当前捕获到异常后，如果需要中断，则直接中断线程即可
     * 当前捕获到异常后，如果不需要中断，需要继续执行线程，则此时需要执行Thread.currentThread().interrupt();重新更改下自己的线程状态为true，表示当前线程需要继续执行；
     * 当前捕获到异常后，如果不需要中断，而是将异常外抛给上层方法进行处理，那么此时也需要执行Thread.currentThread().interrupt();重新更改下自己的线程状态为true，表示当前线程需要继续执行；
     */
    public void basic() {
        Thread testThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println();
            }
        });

        testThread.interrupt();         //是给线程设置中断标志;  其作用是中断此线程（此线程不一定是当前线程，而是指调用该方法的Thread实例所代表的线程）

        testThread.isInterrupted();     //只检测中断;  作用于此线程，即代码中调用此方法的实例所代表的线程;作用是只测试此线程是否被中断 ，不清除中断状态。
        testThread.interrupted();       //是检测中断并清除中断状态； 作用于当前线程(作用是测试当前线程是否被中断（检查中断标志），返回一个boolean并清除中断状态，第二次再调用时中断状态已经被清除，将返回一个false)
        Thread.interrupted();           //同上


        //************************************

        testThread.interrupt(); //设置指定testThread线程的状态为中断标志，

        testThread.isInterrupted();// 检测当前testThread线程是否被外界中断；是则返回true
        testThread.interrupted();//检测当前testThread线程是否收到中断信令，收到信令则返回true且清除中断状态，重新变更为false；
        Thread.interrupted();//静态方法，与testThread.interrupted()一样，（检测当前testThread线程是否被中断，如果被中断则返回true且清除中断状态，重新变更为未中断状态；） 作用于当前被执行线程，由于testThread内部线程在执行的时候，是无法获取testThread引用的，所以如果想检测当前自己的线程是否被中断且清除中断状态，则可以使用Thread.interrupted()方法；


        //如上，其实关于线程中断一共也就上述三个方法，其中interrupt()和isInterrupted() 是线程实例方法，interrupted()则是线程的静态方法；
        //isInterrupted()是线程实例方法，所以，线程内部执行代码中是无法获取testThread的引用的所以无法执行实例方法isInterrupted()；
        //但其实，我们可以通过在线程内部执行代码中使用 Thread.currentThread()获取当前线程的实例，此时使用Thread.currentThread().isInterrupted() 的方式来调用isInterrupted()方法；等价于testThread.isInterrupted();
        //等价与：线程外部做检测用：testThread.isInterrupted(); 线程内部做检测用：Thread.currentThread().isInterrupted()
    }


    public void m1() {
        Thread t = new Thread(() -> {
            System.out.println("Thread start...");
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("running");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println("t interrupt ...");
                    e.printStackTrace();
                }
            }

            LockSupport.park();
            boolean a1 = Thread.interrupted();
            System.out.println("a1:" + a1);

            boolean a2 = Thread.interrupted();
            System.out.println("a2:" + a2);
        });
        t.start();

        boolean isInterrupted1 = t.isInterrupted();
        System.out.println("isInterrupted1:" + isInterrupted1);

        t.interrupt();

        boolean isInterrupted2 = t.isInterrupted();
        System.out.println("isInterrupted2:" + isInterrupted2);

        boolean isInterrupted3 = t.isInterrupted();
        System.out.println("isInterrupted3:" + isInterrupted3);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean a1 = t.interrupted();
        System.out.println("a1:" + a1);

        boolean a2 = t.interrupted();
        System.out.println("a2:" + a2);

        try {
            TimeUnit.SECONDS.sleep(5000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}
