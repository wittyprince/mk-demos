package com.mk.demos.design.pattern.strategy;

/**
 * 客户端
 *
 * @author WangChen
 * Created on 2021/1/24 10:12
 * @since 1.0
 */
public class Client {

    private Context context = new Context();

    /**
     * 客户端决定采用何种策略
     *
     * 选定完策略后交给上下文context来执行
     */
    public void doSomething() {

        Strategy strategy = new StrategyA();
        context.setStrategy(strategy);
        context.operate();

        Strategy b = new StrategyB();
        context.setStrategy(b);
        context.operate();

    }
}
