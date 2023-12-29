package com.mk.demos.jackson.dto;

/**
 * inner 子类
 *
 * @author WangChen
 * Created on 2022/10/18
 * @since 1.0
 */
public class SubInner extends Inner{

    private String sub;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "SubInner{" +
                "sub='" + sub + '\'' +
                '}';
    }
}
