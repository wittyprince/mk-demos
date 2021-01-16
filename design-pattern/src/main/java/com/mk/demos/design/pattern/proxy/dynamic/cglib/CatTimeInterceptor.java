package com.mk.demos.design.pattern.proxy.dynamic.cglib;

import java.lang.reflect.Method;

import com.mk.demos.design.pattern.proxy.Cat;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * time 拦截器
 *
 * @author WangChen
 * Created on 2021/1/15 21:07
 * @since 1.0
 */
public class CatTimeInterceptor implements MethodInterceptor {

    private Cat target;

    public CatTimeInterceptor() {
    }

    public CatTimeInterceptor(Cat target) {
        this.target = target;
    }

    /**
     * 功能主要是在调用业务类方法之前 之后添加统计时间的方法逻辑.
     * 所有生成的代理方法都调用此方法，而不是原始方法。
     * 原始方法既可以通过使用Method对象的常规反射来调用，也可以通过使用MethodProxy（更快）来调用。
     * --------------------
     * intercept 因为具有 MethodProxy proxy 参数的原因 不再需要代理类的引用对象了,直接通过proxy 对象访问被代理对象的方法(这种方式更快)。
     * 当然 也可以通过反射机制，通过 method 引用实例    Object result = method.invoke(target, args); 形式反射调用被代理类方法，
     * target 实例代表被代理类对象引用, 初始化 CglibMethodInterceptor 时候被赋值 。但是Cglib不推荐使用这种方式
     *
     * @param proxyObj    "this", the enhanced object   代表Cglib生成的动态代理类 对象本身
     * @param method      intercepted Method            被代理的方法：即代理类中被拦截的接口方法 Method 实例
     * @param args        argument array; primitive types are wrapped  被代理的方法的方法参数
     * @param methodProxy 被调用方法的代理，它可以和method完成同样的事情，但是它使用FastClass机制非反射执行方法，效率高
     *                    used to invoke super (non-intercepted method); may be called as many times as needed
     *                    用于调用父类真正的业务类方法。可以直接调用被代理类接口方法
     *
     * @return            any value compatible with the signature of the proxied method.
     *                    Method returning void will ignore this value.
     *                    与代理方法签名兼容的任何值。 返回void的方法将忽略此值。
     *
     * @throws Throwable  any exception may be thrown; if so, super method will not be invoked
     */
    @Override
    public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("time interceptor start...");
        // 调用方式一：
        /**
         * proxyObj - 生成的代理对象
         *            the enhanced object, must be the object passed as the first argument to the MethodInterceptor
         */
//        methodProxy.invokeSuper(proxyObj, objects);
        // 调用方式二：
        /**
         * target - 被代理对象
         */
//        methodProxy.invoke(target, args);
        // 调用方式三：
        /**
         * target - 被代理对象
         */
        method.invoke(target, args);
        System.out.println("time interceptor end...");
        return null;
    }
}
