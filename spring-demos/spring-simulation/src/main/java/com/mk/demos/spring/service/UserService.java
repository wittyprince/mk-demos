package com.mk.demos.spring.service;

import com.mk.demos.spring.dao.UserDAO;
import com.mk.demos.tradition.model.User;

/**
 * UserService
 *
 * @author WangChen
 * Created on 2021/1/9 14:42
 * @since 1.0
 */
public class UserService {


    private UserDAO userDAO;

    public void add(User user){
        userDAO.save(user);
    }


    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
