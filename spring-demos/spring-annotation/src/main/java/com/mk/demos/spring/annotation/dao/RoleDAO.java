package com.mk.demos.spring.annotation.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mk.demos.spring.annotation.model.Role;

/**
 * RoleDAO
 *
 * @author WangChen
 * Created on 2021/1/10 14:17
 * @since 1.0
 */
@Repository
public class RoleDAO {

    public void save(Role role){
        System.out.println("role saving...");
    }
}
