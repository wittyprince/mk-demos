package com.mk.demos.java.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * OOMTest
 *
 * @author WangChen
 * Created on 2022/8/12
 * @since 1.0
 */
public class OOMTest {

    public static void main(String[] args) {
        OOMTest test = new OOMTest();
        //heap区OOM测试
        //test.heapOOM();

        //虚拟机栈和本地方法栈溢出
        //test.stackOverflow();

        //metaspace OOM测试
        //test.metaspaceOOM();

        //堆外内存 OOM测试
        //test.directOOM();
    }

    /**
     * heap OOM测试
     */
    public void heapOOM() {
        List<OOMTest> list = new ArrayList<>();
        while (true) {
            list.add(new OOMTest());
        }
    }


    private int stackLength = 1;

    public void stackLeak() {
        stackLength += 1;
        stackLeak();
    }

    /**
     * VM Stack / Native method Stack 溢出测试
     */
    public void stackOverflow() {
        OOMTest test = new OOMTest();
        try {
            test.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + test.stackLength);
            throw e;
        }
    }

    public void genString() {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add("string-" + i);
            i++;
        }
    }

    /**
     * metaspace/常量池 OOM测试
     */
    public void metaspaceOOM() {
        OOMTest test = new OOMTest();
        test.metaspaceOOM();
    }

    public void allocDirectMemory() {
        final int _1MB = 1024 * 1024;

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = null;
        try {
            unsafe = (Unsafe) unsafeField.get(null);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

    /**
     * 堆外内存OOM测试
     */
    public void directOOM() {
        OOMTest test = new OOMTest();
        test.allocDirectMemory();
    }
}
