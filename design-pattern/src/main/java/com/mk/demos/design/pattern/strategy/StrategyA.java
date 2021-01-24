package com.mk.demos.design.pattern.strategy;

/**
 * 策略具体实现类
 *
 * @author WangChen
 * Created on 2021/1/24 10:11
 * @since 1.0
 */
public class StrategyA implements Strategy{
    @Override
    public void doOperation() {
        System.out.println("operate with StrategyA...");
    }

    @Override
    public String toString() {
        return "StrategyA";
    }
}
