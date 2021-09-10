package com.mk.demos.design.pattern.observer.push;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 *
 * @author WangChen
 * Created on 2021/9/7 15:30
 * @since 0.1
 */
public class Test {

    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer o1 = new Observer1();
        Observer o2 = new Observer2();

        subject.register(o1);
        subject.register(o2);

        subject.remove(o1);

        subject.changeState(2);

    }
}
