package com.mk.demos.java.jclass;

import java.net.URL;
import java.util.Arrays;

import sun.misc.Launcher;

/**
 * ClassLoader test
 *
 * @author WangChen
 * Created on 2019/12/22 11:37
 * @since 1.0
 */
public class ClassLoaderTest {

    public static void main(String [] args){
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader.getClass());// class sun.misc.Launcher$AppClassLoader
        System.out.println(classLoader.getParent().getClass());// class sun.misc.Launcher$ExtClassLoader
        System.out.println(classLoader.getParent().getParent());// null


        // 获取BootStrapClassLoader所在的URL下的jar
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        Arrays.stream(urLs).map(URL::toExternalForm).forEach(System.out::println);
    }

}
