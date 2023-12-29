package com.mk.demos.spring.cloud.nacos.config.model;

import lombok.Data;

/**
 * user
 *
 * @author WangChen
 * Created on 2022/10/9
 * @since 1.0
 */
@Data
public class UserInfo {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
