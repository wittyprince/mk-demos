package com.mk.demos.design.pattern.proxy.dynamic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.mk.demos.design.pattern.proxy.Car;
import com.mk.demos.design.pattern.proxy.Movable;

/**
 * 动态代理类-模拟JDK的动态代理类Proxy
 *
 * 需求：
 * 对Car生成一个动态代理类，在Car#move方法前后增加自己的业务逻辑
 *
 * @author WangChen
 * Created on 2021/1/11 20:43
 * @since 1.0
 */
public class Proxy {

    public static Object newProxyInstance() throws IOException {

        return null;
    }

    public static void main(String [] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 注意：如果这里拿到的compiler为null，则可能与配置有关，这里需要配置工程的运行环境为jdk，而不是jre
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler.getClass().getName());
        StandardJavaFileManager javaFileManager = compiler.getStandardFileManager(null, null, null);
        String absolutePath = "D:\\Gitspace\\mk\\mk-demos\\design-pattern\\src\\main\\java\\com\\mk\\demos\\design\\pattern\\proxy\\jstatic\\CarTimeProxy.java";
        Iterable<? extends JavaFileObject> javaFileObjects = javaFileManager.getJavaFileObjects(absolutePath);
        JavaCompiler.CompilationTask task = compiler.getTask(null, javaFileManager, null, null, null, javaFileObjects);
        task.call();// 编译
        javaFileManager.close();

        // load到内存，
        URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src")};
        // 通过URLClassLoader可以加载定义在任何地方的.class二进制文件，如来自网络等
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        String className = "com.mk.demos.design.pattern.proxy.jstatic.CarTimeProxy";
        Class<?> loadClass = urlClassLoader.loadClass(className);
        System.out.println(loadClass);

        // 生成实例 create an instance
        Constructor<?>[] constructors = loadClass.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);
        Constructor<?> constructor = loadClass.getConstructor(null);
        System.out.println("null parameter: " + constructor);
        // 获取loadClass的构造方法
        Constructor<?> movableConstructor = loadClass.getConstructor(Movable.class);
        // 生成实例
        Movable o = (Movable) movableConstructor.newInstance(new Car());
        // 调用方法
        o.move();
    }
}
