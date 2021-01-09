package com.mk.demos.tradition.dao.impl;

import com.mk.demos.tradition.dao.UserDAO;
import com.mk.demos.tradition.model.User;

/**
 * UserDAO 具体实现类
 *
 * @author WangChen
 * Created on 2021/1/9 14:04
 * @since 1.0
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void save(User user) {
        System.out.println("user saving..." + user);
        // 这里写具体的save逻辑
    }
}
