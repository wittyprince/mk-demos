package com.mk.demos.java.jclass;

import java.io.IOException;
import java.io.InputStream;

/**
 * 如果不是同一个ClassLoader加载的同一个类，使用instanceof判断也不会相等
 *
 * @author WangChen
 * Created on 2020/4/14 15:39
 * @since
 */
public class ClassLoaderForInstanceofTest {

    public static void main(String [] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
//                return super.loadClass(name);
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    //e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myClassLoader.loadClass("com.mk.demos.java.jclass.ClassLoaderForInstanceofTest")
                .newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.mk.demos.java.jclass.ClassLoaderForInstanceofTest);
    }
}
