package com.mk.demos.mybatis.model;

/**
 * User
 *
 * @author WangChen
 * Created on 2023/5/5
 * @since 1.0
 */
import io.mybatis.provider.Entity;

@Entity.Table("user")
public class User {
    @Entity.Column(id = true)
    private Long   id;
    @Entity.Column("name")
    private String username;
    @Entity.Column
    private String sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    //省略set和get方法
}
