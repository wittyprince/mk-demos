package com.mk.demo.mybatis.po;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * 项目基类
 * Created by WangChen on 2019/1/27 19:10.
 */
@Data
public class BaseEntity {

    private Integer id;
    private String createBy;
    private String lastModifiedBy;
    private LocalDateTime createDateTime;
    private LocalDateTime lastModifiedDateTime;
    private Integer version;
    private Boolean available;

}
