package com.mk.demos.java.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupportTest
 *
 * @author WangChen
 * Created on 2024/10/17
 * @since 1.0
 */
public class LockSupportTest {


    public static void main(String[] args) {

        // ========代码块1==================================================================================================
        LockSupport.unpark(Thread.currentThread());// 唤醒主线程
        System.out.println("main thread unpark");
        LockSupport.park(); // 阻塞主线程
        System.out.println("main thread start");
        // 以上代码块，并不会造成主线程阻塞，
        // 如果事先针对某个线程调用了 unpark 方法，则该线程继续调用 park 方法并不会进入阻塞状态，而是会立即返回
        // ==========================================================================================================


        // ========代码块2==================================================================================================
        Thread mainThread = Thread.currentThread();
        Thread subThread = new Thread(() -> {
            try {
                System.out.println("sub thread start");
                Thread.sleep(3000);
                System.out.println("sub thread sleep 3s");
                LockSupport.unpark(mainThread);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(mainThread);
            System.out.println("unpark main thread");
        });
        subThread.start();

        System.out.println("main thread start");
        LockSupport.park(); // 阻塞主线程
        System.out.println("main thread unpark");
        LockSupport.unpark(Thread.currentThread());// 唤醒主线程
        // 如果没有在子线程subThread中调用LockSupport.unpark(mainThread);的话，
        // 以上代码会阻塞主线程，所以park()方法后的代码并不会继续执行了，
        // 如果想要唤醒主线程，在其他线程中调用LockSupport.unpark(Thread.currentThread())方法
        // ==========================================================================================================

        System.out.println("main thread end");
    }


}
