package com.mk.demos.java8.chapter2;

import org.junit.Test;

/**
 * @author WangChen
 * Created on 2019/4/15 21:51
 * @since
 */
public class FunctionalInterfaceImplTest {

    public static void main(String[] args){
//        FunctionalInterfaceTest test = System.out::println;
//        test.print("func interface test...");
        FunctionalInterfaceImplTest t1 = new FunctionalInterfaceImplTest();
        t1.test();
    }

    @Test
    public void test(){
        FunctionalInterfaceTest test = System.out::println;
        test.print("func interface test...");
    }
}
