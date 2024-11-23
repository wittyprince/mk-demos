package com.mk.demos.java.concurrent;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadPoolExecutorTest
 *
 * @author WangChen
 * Created on 2024/11/21
 * @since 1.0
 */
public class ThreadPoolExecutorRunStateTest {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        // Assuming you have a ThreadPoolExecutor instance named executor
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

//        // Retrieve the ctl field using reflection
//        Field ctlField = ThreadPoolExecutor.class.getDeclaredField("ctl");
//        ctlField.setAccessible(true);
//        AtomicInteger ctl = (AtomicInteger) ctlField.get(executor);
//
//        // Get the runState using the runStateOf method
////        Object runState = ThreadPoolExecutor.class.getDeclaredMethod("runStateOf", int.class).invoke(null, ctl);
//        int runState = runStateOf(ctl.get());
//
//        // Print the runState
//        System.out.println("Run state: " + runState);

        getRunStateOfExecutor(executor1); // -536870912 = RUNNING

        executor1.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executor1.shutdown();
        getRunStateOfExecutor(executor1); // 1610612736 = TERMINATED
        executor1.shutdownNow();
        getRunStateOfExecutor(executor1); // 536870912 = STOP

        // ==========================
        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        getRunStateOfExecutor(executor2); // -536870912 = RUNNING
        executor2.shutdown();
        getRunStateOfExecutor(executor2); // 0 = SHUTDOWN

    }

    private static int getRunStateOfExecutor(ThreadPoolExecutor executor) throws NoSuchFieldException, IllegalAccessException {
        // Retrieve the ctl field using reflection
        Field ctlField = ThreadPoolExecutor.class.getDeclaredField("ctl");
        ctlField.setAccessible(true);
        AtomicInteger ctl = (AtomicInteger) ctlField.get(executor);

        // Get the runState using the runStateOf method
//        Object runState = ThreadPoolExecutor.class.getDeclaredMethod("runStateOf", int.class).invoke(null, ctl);
        int runState = runStateOf(ctl.get());

        // Print the runState
        System.out.println("Run state: " + runState);
        return runState;
    }

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    private static int runStateOf(int c)     { return c & ~CAPACITY; }


}
