package com.mk.demos.design.pattern.strategy;

/**
 * 需要用到策略的类
 *
 * @author WangChen
 * Created on 2021/1/24 10:17
 * @since 1.0
 */
public class Context {

    private Strategy strategy;

    private Context() {
    }

    /**
     * 构造函数
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * setter方法，可以动态设置要使用的具体策略
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }


    public void operate(){
        System.out.println("Context is running with strategy: " + strategy);
        strategy.doOperation();
    }

}
