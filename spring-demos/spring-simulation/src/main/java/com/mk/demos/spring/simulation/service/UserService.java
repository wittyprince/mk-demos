package com.mk.demos.spring.simulation.service;

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
     * 注意这里userDAO硬编码时先缺省，等到需要使用时，再装配(注入)
     */
    UserDAO userDAO;


    public void add(User user){
        userDAO.save(user);
    }

    /**
     * 这里需要set方法，否则Method.invoke(o, beanObject);反射方法设置不进来
     */
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
