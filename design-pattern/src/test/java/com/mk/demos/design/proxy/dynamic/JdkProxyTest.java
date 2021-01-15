package com.mk.demos.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 * JDK 自带的Proxy代理类 测试
 *
 * 可以参考：https://cloud.tencent.com/developer/article/1461796
 *
 * @author WangChen
 * Created on 2021/1/14 20:13
 * @since 1.0
 */
public class JdkProxyTest {

    @Test
    public void test(){
        Bat bat = new Bat();
        Flyable f = (Flyable) Proxy.newProxyInstance(
                JdkProxyTest.class.getClassLoader(),
                new Class[]{Flyable.class},
                new BatHandler(bat));
//        System.out.println(f.toString());
        f.fly();
    }

    class BatHandler implements InvocationHandler {
        Bat bat;

        public BatHandler(Bat bat) {
            this.bat = bat;
        }

        /**
         *
         * @param proxy1 代表动态生成的 动态代理 对象实例
         * @param method 代表被调用委托类的接口方法，和生成的代理类实例调用的接口方法是一致的，它对应的Method 实例
         * @param args  代表调用接口方法对应的Object参数数组，如果接口是无参，则为null； 对于原始数据类型返回的他的包装类型。
         * @return Object
         * @throws Throwable t
         */
        @Override
        public Object invoke(Object proxy1, Method method, Object[] args) throws Throwable {
            System.out.println("BatHandler start...");
            Object invoke = method.invoke(bat, args);
            System.out.println("BatHandler end...");
            return invoke;
        }
    }

    interface Flyable{
        void fly();
    }
    class Bat implements Flyable{

        @Override
        public void fly() {
            System.out.println("Bat flying...");
        }
    }
}
