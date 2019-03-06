package com.mk.demo.mybatis.po;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 用户类
 * Created by WangChen on 2019/1/27 19:41.
 */
@Data
@ToString
@Accessors
public class User extends BaseEntity {

    private String name;
    private Integer age;
}
