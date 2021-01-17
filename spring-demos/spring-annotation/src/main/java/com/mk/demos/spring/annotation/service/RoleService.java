package com.mk.demos.spring.annotation.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.mk.demos.spring.annotation.dao.RoleDAO;
import com.mk.demos.spring.annotation.model.Role;

/**
 * Role Service
 *
 * @author WangChen
 * Created on 2021/1/10 13:15
 * @since 1.0
 */
@Component
public class RoleService {


    @Resource
    private RoleDAO roleDAO;

    public void add(Role role){
        System.out.println("role adding ... ");
        roleDAO.save(role);
    }

}
