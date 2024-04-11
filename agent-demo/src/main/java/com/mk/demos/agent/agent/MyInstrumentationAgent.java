package com.mk.demos.agent.agent;

import com.mk.demos.agent.agent.AtmTransformer;

import java.lang.instrument.Instrumentation;

/**
 * MyInstrumentationAgent
 *
 * @author WangChen
 * Created on 2024/4/10
 * @since 1.0
 */
public class MyInstrumentationAgent {

    /**
     * 静态代理入口方法
     */
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("[Agent] In premain method");

        String className = "com.mk.demos.agent.application.MyAtm";
        transformClass(className, inst);
    }

    /**
     * 动态代理入口方法
     */
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("[Agent] In agentmain method");

        String className = "com.mk.demos.agent.application.MyAtm";
        transformClass(className, inst);
    }

    private static void transformClass(String className, Instrumentation instrumentation) {
        Class<?> targetCls = null;
        ClassLoader targetClassLoader = null;
        // see if we can get the class using forName
        try {
            targetCls = Class.forName(className);
            targetClassLoader = targetCls.getClassLoader();
            transform(targetCls, targetClassLoader, instrumentation);
            return;
        } catch (Exception ex) {
            System.err.println("Class ["+ className + "] not found with Class.forName");
        }
        // otherwise iterate all loaded classes and find what we want
        for(Class<?> clazz: instrumentation.getAllLoadedClasses()) {
            if(clazz.getName().equals(className)) {
                targetCls = clazz;
                targetClassLoader = targetCls.getClassLoader();
                transform(targetCls, targetClassLoader, instrumentation);
                return;
            }
        }
        throw new RuntimeException("Failed to find class [" + className + "]");
    }

    private static void transform(Class<?> clazz, ClassLoader classLoader, Instrumentation instrumentation) {
        AtmTransformer dt = new AtmTransformer(clazz.getName(), classLoader);
        instrumentation.addTransformer(dt, true);
        try {
            instrumentation.retransformClasses(clazz);
        } catch (Exception ex) {
            throw new RuntimeException("Transform failed for class: [" + clazz.getName() + "]", ex);
        }
    }
}
