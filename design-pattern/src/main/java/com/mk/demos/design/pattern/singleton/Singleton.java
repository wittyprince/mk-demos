package com.mk.demos.design.pattern.singleton;

/**
 * 单例模式
 *
 * @author WangChen
 * Created on 2021/3/3 10:45
 * @since 1.0
 */
public class Singleton {

    // 方式一：饿汉模式
    // 述代码中的一个缺点是该类加载的时候就会直接new 一个静态对象出来，当系统中这样的类较多时，会使得启动速度变慢 。
    // 现在流行的设计都是讲“延迟加载”，我们可以在第一次使用的时候才初始化第一个该类对象。所以这种适合在小系统
    /*private static Singleton sin = new Singleton();    ///直接初始化一个实例对象

    private Singleton() {    ///private类型的构造函数，保证其他类对象不能直接new一个该对象的实例
    }

    public static Singleton getSin() {    ///该类唯一的一个public方法
        return sin;
    }*/

    // 方式二：使用同步方法，代码中的一次锁住了一个方法， 这个粒度有点大
    /*private static Singleton instance;
    private Singleton() {}
    public static synchronized Singleton getInstance() {    //对获取实例的方法进行同步
        if (instance == null)
            instance = new Singleton();
        return instance;
    }*/

    // 方式三：正确的双重检查锁
    // uniqueSingleton前加入关键字volatile。
    // 使用了volatile关键字后，重排序被禁止，所有的写（write）操作都将发生在读（read）操作之前。
    /*private volatile static Singleton uniqueSingleton;
    private Singleton() {}
    public Singleton getInstance() {
        if (null == uniqueSingleton) {
            synchronized (Singleton.class) {
                if (null == uniqueSingleton) {
                    uniqueSingleton = new Singleton();
                }
            }
        }
        return uniqueSingleton;
    }*/

    // 方式四：静态内部类
    private Singleton() {}
    public Singleton getInstance() {
        return Inner.s;
    }
    private static class Inner{
        private static Singleton s = new Singleton();
    }
}
