package com.mk.demos.mapstruct.complex.expression;

/**
 * task status enum
 *
 * @author WangChen
 * Created on 2021/7/30 13:30
 * @since 0.1
 */
public enum TaskStatusEnum {
    UNFINISHED(0, "未完成"), // created
    FINISHED(1, "已完成"), // finished
    ;


    private Integer code;
    private String name;

    TaskStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode(Integer code) {
        for(TaskStatusEnum t : values()) {
            if(t.code.equals(code)) {
                return t.getName();
            }
        }
        return null;
    }

}
