package com.mk.demos.java.instance;

import org.omg.Messaging.SyncScopeHelper;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * JInstanceDemo
 *
 * @author WangChen
 * Created on 2024/11/5
 * @since 1.0
 */
public class JInstanceDemo {

    private Integer i1;
    private static Integer i2;

    private String s1;
    private static String s2 ;

    public static void main(String[] args) {

        System.out.println(VM.current().details());
        System.out.println("====================================");
        System.out.println(ClassLayout.parseClass(String.class).toPrintable());

        System.out.println("====================================");
        System.out.println(ClassLayout.parseInstance("www.baidu.com").toPrintable());

        JInstanceDemo demo1 = new JInstanceDemo();


    }
}
