package com.mk.demos.spring.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mk.demos.spring.annotation.dao.UserDAO;
import com.mk.demos.spring.annotation.model.Role;
import com.mk.demos.spring.annotation.model.User;

/**
 * User Service
 *
 * @author WangChen
 * Created on 2021/1/10 10:56
 * @since 1.0
 */
public class UserService {

    /**
     *  @Autowired 标注在属性上，不需要该属性有setter方法，Spring也能注入，原理？
     *  先根据type，再看name，再看primary ?
     */
    @Autowired
    private UserDAO userDAO;

    @Autowired(required = false)
    private RoleService roleService;

    public void add(User user){
        userDAO.save(user);
    }

    public void add(Role role){
        roleService.add(role);
    }

//    public UserService(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }

//    public UserService(RoleService roleService) {
//        this.roleService = roleService;
//    }
}
