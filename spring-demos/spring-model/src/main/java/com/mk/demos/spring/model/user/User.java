package com.mk.demos.spring.model.user;

/**
 * User实体类
 *
 * @author WangChen
 * Created on 2021/4/9 15:18
 * @since 1.0
 */
public class User {

    private Long id;
    private String name;
    private Profile profile;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profile=" + profile +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
