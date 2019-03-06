package com.mk.demo.mybatis.mapper;

import com.mk.demo.mybatis.po.User;

/**
 * user mapper
 * Created by WangChen on 2019/1/27 19:45.
 */
public interface UserMapper {

    void save(User user);

    User findById(int id);
}
