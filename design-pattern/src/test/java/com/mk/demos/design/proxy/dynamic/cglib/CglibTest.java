package com.mk.demos.design.proxy.dynamic.cglib;

import org.junit.Test;

import com.mk.demos.design.pattern.proxy.Cat;
import com.mk.demos.design.pattern.proxy.dynamic.cglib.CatTimeInterceptor;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * CGLib test
 *
 * @author WangChen
 * Created on 2021/1/15 21:22
 * @since 1.0
 */
public class CglibTest {
    @Test
    public void test(){
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, System.getProperty("user.dir"));
        Cat cat = new Cat();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Cat.class);
        enhancer.setCallback(new CatTimeInterceptor(cat));
        Cat proxyCat = (Cat)enhancer.create();
        proxyCat.bark();
    }
    /**
     *分析过程：
     *1、创建Enhancer实例
     *2、设置目标类Target为Enhancer的父类，同时为Target的每个非private方法生成两个方法：以g()方法为例，
     *   会生成：g()和CGLIB$g$0。测试代码中t.g()调用的是代理类的g()
     *3、设置拦截器
     *4、1)调用t.g(),g()方法先判断是否已经存在实现了MethodInterceptor接口的拦截对象，如果没有的话就调用
     *   CGLIB$BIND_CALLBACKS方法来获取拦截对象；
     *   2)CGLIB$BIND_CALLBACKS先从CGLIB$THREAD_CALLBACKS中get拦截对象，如果获取不到的话，再从
     *   CGLIB$STATIC_CALLBACKS来获取，如果也没有则认为该方法不需要代理。
     *   3)拦截对象是如何设置到CGLIB$THREAD_CALLBACKS 或者 CGLIB$STATIC_CALLBACKS中的呢？即cglib代理是在
     *  eh.create()时调用了firstInstance方法来生成代理类实例并设置拦截对象。
     *  4)当获取到拦截对象，再调用
     *  tmp4_1.intercept(this, CGLIB$g$0$Method, CGLIB$emptyArgs, CGLIB$g$0$Proxy)来实现代理
     *5、tmp4_1.intercept(this, CGLIB$g$0$Method, CGLIB$emptyArgs, CGLIB$g$0$Proxy)中的tmp4_1为拦截器，
     *   参数解析,第1个:代理对象本身;第2个:被拦截的方法对象;第3个:方法调用入参;第4个:被拦截方法的方法代理对象,
     *   此时调用MyInterceptor的intercept方法进行代理
     *6、调用proxy.invokeSuper(obj, args)，这里使用的是FastClass机制，FastClass机制就是对一个类的方法建立索引，
     *   通过索引来直接调用相应的方法，当调用invokeSuper方法时，实际上是调用代理类的CGLIB$g$0方法，
     *   CGLIB$g$0直接调用了目标类的g方法
     */
}
