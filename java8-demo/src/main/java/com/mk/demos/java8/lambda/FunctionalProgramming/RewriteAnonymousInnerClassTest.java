package com.mk.demos.java8.lambda.FunctionalProgramming;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }
}
