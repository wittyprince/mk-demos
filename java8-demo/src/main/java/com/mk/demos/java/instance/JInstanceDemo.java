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
        System.out.println("====================================");
        System.out.println(ClassLayout.parseInstance(demo1).toPrintable());
        //com.mk.demos.java.instance.JInstanceDemo object internals:
        //OFF  SZ                TYPE DESCRIPTION               VALUE
        //  0   8                     (object header: mark)     0x0000000000000005 (biasable; age: 0)
        //  8   4                     (object header: class)    0x2000c105
        // 12   4   java.lang.Integer JInstanceDemo.i1          null
        // 16   4    java.lang.String JInstanceDemo.s1          null
        // 20   4                     (object alignment gap)
        //Instance size: 24 bytes
        //Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


    }
}
