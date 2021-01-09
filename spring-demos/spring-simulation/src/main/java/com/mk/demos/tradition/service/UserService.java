package com.mk.demos.tradition.service;

import com.mk.demos.tradition.dao.UserDAO;
import com.mk.demos.tradition.dao.impl.UserDAOImpl;
import com.mk.demos.tradition.model.User;

/**
 * UserService User服务类(负责处理具体的业务逻辑)
 *
 * @author WangChen
 * Created on 2021/1/9 14:06
 * @since 1.0
 */
public class UserService {

    /**
     * 注意这里userDAO在硬编码时是我们自己new出来的
     */
    UserDAO userDAO = new UserDAOImpl();


    public void add(User user){
        userDAO.save(user);
    }
}
