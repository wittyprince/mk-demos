package com.mk.demos.spring.model.user.enumtype;

/**
 * 头衔，职务
 *
 * @author WangChen
 * Created on 2021/4/10 20:22
 * @since 1.0
 */
public enum TitleEnum {

    EMPLOYEE("employee", "职员"),
    MANAGER("manager", "经理");

    TitleEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
    String code;
    String name;
}
