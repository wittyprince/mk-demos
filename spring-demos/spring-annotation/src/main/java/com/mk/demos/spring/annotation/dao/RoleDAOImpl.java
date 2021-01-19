package com.mk.demos.spring.annotation.dao;

import org.springframework.stereotype.Repository;

import com.mk.demos.spring.annotation.model.Role;

/**
 * role dao impl
 *
 * @author WangChen
 * Created on 2021/1/19 21:15
 * @since 1.0
 */
@Repository
public class RoleDAOImpl implements RoleDAO{

    @Override
    public void save(Role role){
        System.out.println("role saving...");
    }
}
