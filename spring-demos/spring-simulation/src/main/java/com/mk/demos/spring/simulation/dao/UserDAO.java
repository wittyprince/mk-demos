package com.mk.demos.spring.simulation.dao;

import com.mk.demos.tradition.model.User;

/**
 * User DAO (Data Access Object)
 *
 * 抽象出DAO层，以适配不同存储介质，如数据库(oracle, mysql,...),文件等
 *
 * @author WangChen
 * Created on 2021/1/9 14:01
 * @since 1.0
 */
public interface UserDAO {

    void save(User user);
}
