package com.mk.demos.java.jclass;

import java.net.URL;
import java.util.Arrays;

import sun.misc.Launcher;
import sun.misc.URLClassPath;

/**
 * ClassLoader test
 *
 * @author WangChen
 * Created on 2019/12/22 11:37
 * @since 1.0
 */
public class ClassLoaderTest {

    public static void main(String [] args){

        System.out.println(Launcher.getLauncher().getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b

        System.out.println(ClassLoader.getSystemClassLoader()); // sun.misc.Launcher$AppClassLoader@18b

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader.getClass());// class sun.misc.Launcher$AppClassLoader
        System.out.println(classLoader.getParent().getClass());// class sun.misc.Launcher$ExtClassLoader
        System.out.println(classLoader.getParent().getParent());// null


        // 获取BootStrapClassLoader所在的URL下的jar
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        Arrays.stream(urLs).map(URL::toExternalForm).forEach(System.out::println);
        // file:/D:/tools/jdk/jdk1.8/jre/lib/resources.jar
        // file:/D:/tools/jdk/jdk1.8/jre/lib/rt.jar
        // file:/D:/tools/jdk/jdk1.8/jre/lib/sunrsasign.jar
        // file:/D:/tools/jdk/jdk1.8/jre/lib/jsse.jar
        // file:/D:/tools/jdk/jdk1.8/jre/lib/jce.jar
        // file:/D:/tools/jdk/jdk1.8/jre/lib/charsets.jar
        // file:/D:/tools/jdk/jdk1.8/jre/lib/jfr.jar
        // file:/D:/tools/jdk/jdk1.8/jre/classes
        // 可以看到，BootStrapClassLoader加载的是jre/lib下的jar包，这些jar包是JVM的核心类库，是JVM运行时必须的类库
        // 并没有加载jre/lib/ext目录下的jar包，如：
        // file:/D:/tools/jdk/jdk1.8/jre/lib/ext/access-bridge-64.jar
        // 也没有加载D:\tools\jdk\jdk1.8\lib下的包，如：
        // D:\tools\jdk\jdk1.8\lib\tools.jar

        System.out.println("====================================");

        // Get the system class path - sun.boot.class.path
        // sun.boot.class.path 是在 sun.misc.Launcher#bootClassPath 中定义的
        String bootClassPath = System.getProperty("sun.boot.class.path");
        // Split the class path into individual paths
        String[] paths = bootClassPath.split(System.getProperty("path.separator"));
        // Print each path
        Arrays.stream(paths).forEach(System.out::println);
        // 结果同上
        // D:\tools\jdk\jdk1.8\jre\lib\resources.jar
        // D:\tools\jdk\jdk1.8\jre\lib\rt.jar
        // D:\tools\jdk\jdk1.8\jre\lib\sunrsasign.jar
        // D:\tools\jdk\jdk1.8\jre\lib\jsse.jar
        // D:\tools\jdk\jdk1.8\jre\lib\jce.jar
        // D:\tools\jdk\jdk1.8\jre\lib\charsets.jar
        // D:\tools\jdk\jdk1.8\jre\lib\jfr.jar
        // D:\tools\jdk\jdk1.8\jre\classes

    }

}
