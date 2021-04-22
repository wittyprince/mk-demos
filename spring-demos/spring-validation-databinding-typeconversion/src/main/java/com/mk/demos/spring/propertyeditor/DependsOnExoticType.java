package com.mk.demos.spring.propertyeditor;

/**
 * 依赖ExoticType的类
 *
 * @author WangChen
 * Created on 2021/4/22 20:04
 * @since 1.0
 */
public class DependsOnExoticType {

    private ExoticType type;

    public void setType(ExoticType type) {
        this.type = type;
    }

    public ExoticType getType() {
        return type;
    }
}
