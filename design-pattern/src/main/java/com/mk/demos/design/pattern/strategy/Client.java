package com.mk.demos.design.pattern.strategy;

/**
 * 测试类
 *
 * @author WangChen
 * Created on 2021/1/24 10:12
 * @since 1.0
 */
public class Client {

    public static void main(String [] args){
        Context context = new Context(new StrategyA());
        context.operate();
        context.setStrategy(new StrategyB());// 可以动态改变具体需要使用的策略
        context.operate();

    }
}
