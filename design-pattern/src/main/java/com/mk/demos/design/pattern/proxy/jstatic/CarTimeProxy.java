package com.mk.demos.design.pattern.proxy.jstatic;

import com.mk.demos.design.pattern.proxy.Car;
import com.mk.demos.design.pattern.proxy.Movable;

/**
 * car 记录时间 代理类
 *
 * @author WangChen
 * Created on 2021/1/10 21:33
 * @since 1.0
 */
public class CarTimeProxy implements Movable {
    public CarTimeProxy() {
    }

    private Movable movable;

    public CarTimeProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("TimeProxy start...");
        movable.move();
        System.out.println("TimeProxy end...");
    }
}
