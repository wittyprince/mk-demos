package com.mk.demos.java.jclass;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义class loader
 *
 * 继承java.lang.ClassLoader, 重写 findClass()方法, 调用defineClass
 *
 * @author WangChen
 * Created on 2019/12/22 11:27
 * @since 1.0
 */
public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomPath(name);
            if (result == null) {
                throw new FileNotFoundException();
            } else {
                return defineClass(name, result, 0, result.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException(name);
    }

    private byte[] getClassFromCustomPath(String fileName) {
        // 从自定义路径中加载指定类
        fileName = fileName.replace('.', File.separatorChar) + ".class";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        byte[] buffer;
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ( (nextValue = inputStream.read()) != -1 ) {
                byteOutputStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteOutputStream.toByteArray();
        return buffer;
    }

    public static void main(String [] args) throws ClassNotFoundException {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class<?> aClass = customClassLoader.findClass("com.mk.demos.java.jclass.CustomClassLoader");

        try {
            Class<?> clazz = Class.forName("com.mk.demos.java.jclass.CustomClassLoader", true, customClassLoader);
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
