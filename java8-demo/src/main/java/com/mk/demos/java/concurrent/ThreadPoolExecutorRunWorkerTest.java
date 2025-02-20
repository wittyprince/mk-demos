package com.mk.demos.java.concurrent;

/**
 * ThreadPoolExecutorRunWorkerTest
 *
 * @author WangChen
 * Created on 2024/11/23
 * @since 1.0
 */
public class ThreadPoolExecutorRunWorkerTest {

    public static void main(String[] args) {
        Thread wt = Thread.currentThread();
        Task task;
        boolean completedAbruptly = true;
        try {
            while ((task = getTask()) != null) {
//                w.lock();
                // If pool is stopping, ensure thread is interrupted;
                // if not, ensure thread is not interrupted.  This
                // requires a recheck in second case to deal with
                // shutdownNow race while clearing interrupt
                // 下面代码的意思是，如果线程池正在stop，那么要确保当前工作线程是中断状态
                // 1.1 线程池至少是STOP状态，即STOP, TIDYING, TERMINATED
                // 1.2 或者 当前线程wt被标记为中断 且 当前线程池状态至少为STOP
                // 2. 并且 当前线程wt未被中断
                // 那么中断 当前线程wt
                // snippet①
//                if ((runStateAtLeast(ctl.get(), STOP)
//                        || (Thread.interrupted() && runStateAtLeast(ctl.get(), STOP))
//                ) && !wt.isInterrupted()
//                )
//                    wt.interrupt();
                if ( 1 == 1) {
//                    throw new RuntimeException("w.lock()");
                }

                // 执行run()方法，及钩子方法beforeExecute() 和 afterExecute()
                try {
                    // 钩子方法，任务执行前
                    beforeExecute(wt, task);
                    Throwable thrown = null;
                    try {
                        task.run();
                    } catch (RuntimeException x) {
                        thrown = x; throw x;
                    } catch (Error x) {
                        thrown = x; throw x;
                    } catch (Throwable x) {
                        thrown = x; throw new Error(x);
                    } finally {
                        // 钩子方法，任务执行后
                        afterExecute(task, thrown);
                    }
                } finally {
                    // 最后，run()执行完毕后，把task设置为null，完成任务数+1，w.unlock()
                    // 清空task临时变量，这个很重要，否则while会死循环执行同一个task
                    task = null;
//                    w.completedTasks++;
                    // Worker解锁，本质是AQS释放资源，设置state为0
//                    w.unlock();
                }
            }
            // 走到这里说明某一次getTask()返回为null，线程正常退出
            // 如果while循环中的
            //          - getTask()方法抛出异常
            //          - 代码段①
            //          - 或者 钩子函数beforeExecute()和afterExecute()
            //     执行过程中出现了异常，
            //     那么 此处 completedAbruptly = false; 不会被执行
            // 如果上述未出现异常，那么 completedAbruptly = false
            // 最后的finally中会 根据 completedAbruptly 来对worker进行exit操作处理。
            completedAbruptly = false;
        } finally {
//            processWorkerExit(w, completedAbruptly);
            System.out.println("processWorkerExit!_completedAbruptly:" + completedAbruptly);
        }
    }

    static Task getTask() {
//        throw new RuntimeException("getTask!");
//        return null;
        return new Task();
    }

    static void beforeExecute(Thread t, Runnable r) {
        throw new RuntimeException("beforeExecute!");
    }

    static void afterExecute(Runnable r, Throwable t) {
        throw new RuntimeException("afterExecute!");
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Task run!");
        }
    }
}
