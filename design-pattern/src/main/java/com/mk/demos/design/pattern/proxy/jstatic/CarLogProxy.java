package com.mk.demos.design.pattern.proxy.jstatic;

import com.mk.demos.design.pattern.proxy.Car;
import com.mk.demos.design.pattern.proxy.Movable;

/**
 * car log 代理 类
 *
 * @author WangChen
 * Created on 2021/1/10 21:31
 * @since 1.0
 */
public class CarLogProxy implements Movable {

    private Movable movable;

    public CarLogProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("LogProxy start...");
        movable.move();
        System.out.println("LogProxy end...");
    }
}
