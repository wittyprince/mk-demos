package com.mk.demos.design.pattern.proxy.fromother;

/**
 * 方法用时监控类
 *
 * @author WangChen
 * Created on 2021/1/15 16:25
 * @since 1.0
 */
public class MonitorUtil {
    private static ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    /**
     * 结束时打印耗时
     */
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法执行耗时" + (finishTime - tl.get()) + "ms");
    }
}
