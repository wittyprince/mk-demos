package com.mk.demos.spring.dao.impl;

import com.mk.demos.spring.dao.UserDAO;
import com.mk.demos.tradition.model.User;

/**
 * UserDAOImpl
 *
 * @author WangChen
 * Created on 2021/1/9 14:51
 * @since 1.0
 */
public class UserDAOImpl implements UserDAO {

    public void save(User user){
        System.out.println("spring user saving..." + user);
        // 这里写具体的save逻辑
    }
}
