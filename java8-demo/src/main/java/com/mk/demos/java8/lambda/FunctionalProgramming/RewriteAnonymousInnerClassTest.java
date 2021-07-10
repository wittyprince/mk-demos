package com.mk.demos.java8.lambda.FunctionalProgramming;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * 改写匿名内部类
 *
 * @author WangChen
 * Created on 2021/7/9 23:21
 * @since 1.0
 */
public class RewriteAnonymousInnerClassTest {
    public static void main(String [] args){
        // 这段代码的问题是：
        // 匿名内部类，样板代码，比较难读，且没有清楚的表达程序员的意图。(我们不想传入对象，只想传入行为)
        Button button = new Button();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button 被调用了...");
            }
        });

        // 改写为 lambda 表达式 ，如下：
        // 改写的思路：查看addActionListener的参数形式，得知ActionListener是一个接口，且只有一个未实现的方法。该未实现的方法是void类型的。
        // 所以，就按照这个接口中的方法来改写即可。
        button.addActionListener((a) -> {        });
        // 注意：参数a, 没有声明其具体类型，这是因为 javac 可以根据程序的上下文(addActionListener方法的签名)
        //      在后台推断出参数a的具体类型。也可以指明参数类型，如下：
        button.addActionListener((ActionEvent a) -> {        });

        // Lambda表达式的不同形式
        // ------------------------1. Thread----------------------------
        // Thread 无需参数，无返回值
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        // 可以改写为，如下
        new Thread(() -> {});
        // ------------------------2. Runnable----------------------------
        // Runnable 无需参数，无返回值
        Runnable r1 = new Runnable() {
            @Override
            public void run() {

            }
        };
        //
        Runnable r2 = () -> {}; // Runnable#run() 无需参数，无返回值

        // ------------------------3. ActionListener----------------------------
        // ActionListener 需要一个参数，无返回值
        ActionListener a = (e) -> {}; // ActionListener#actionPerformed(ActionEvent e) 需要一个参数，无返回值

        // ------------------------4. BinaryOperator----------------------------
        // BinaryOperator 二元操作器，继承自 BiFunction#apply(T t, U u)，接收两个参数 T 和 U, 返回 R .
        BinaryOperator<Integer> b = (x, y) -> x + y; // BiFunction#apply(T t, U u)
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y; // 也可以明确参数类型


    }
}
