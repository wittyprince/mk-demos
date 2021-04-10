package com.mk.demos.spring.model.user;

import java.util.Date;

import com.mk.demos.spring.model.user.enumtype.TitleEnum;

/**
 * 用户 简介
 *
 * @author WangChen
 * Created on 2021/4/10 20:09
 * @since 1.0
 */
public class Profile {

    private TitleEnum title;

    @Override
    public String toString() {
        return "Profile{" +
                "title=" + title +
                '}';
    }

    public TitleEnum getTitle() {
        return title;
    }

    public void setTitle(TitleEnum title) {
        this.title = title;
    }


}
