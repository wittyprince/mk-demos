package com.mk.demos.design.pattern.proxy.fromother.jdk;

/**
 * 动态代理委托类实现， 实现接口 Person。 被动态生成的代理类代理
 *
 * @author WangChen
 * Created on 2021/1/15 16:23
 * @since 1.0
 */
public class SoftwareEngineer implements Person {
    public SoftwareEngineer() {
    }

    public SoftwareEngineer(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void goWorking(String name, String dst) {
        System.out.println(
                "被代理类-实际方法调用执行：" +
                " name = " + name + ", 去 " + dst + " 工作"
        );
    }
}
