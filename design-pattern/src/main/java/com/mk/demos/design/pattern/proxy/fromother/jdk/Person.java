package com.mk.demos.design.pattern.proxy.fromother.jdk;

/**
 *
 * 创建Person 接口 用于定义 委托类和代理类之间的约束行为
 *
 * @author WangChen
 * Created on 2021/1/15 16:22
 * @since 1.0
 */
public interface Person {
    /**
     * @param name 人名
     * @param dst  工作目的地
     */
    void goWorking(String name, String dst);

    /**
     * 获取名称
     */
    String getName();

    /**
     * 设置名称
     */
    void setName(String name);
}