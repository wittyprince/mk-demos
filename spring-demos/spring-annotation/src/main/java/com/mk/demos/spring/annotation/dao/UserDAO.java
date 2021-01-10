package com.mk.demos.spring.annotation.dao;

import com.mk.demos.spring.annotation.model.User;

/**
 * User DAO
 *
 * @author WangChen
 * Created on 2021/1/10 10:56
 * @since 1.0
 */
public class UserDAO {

    private Long userDAOId;

    public void save(User user){
        System.out.println("userDAOId: " + userDAOId + "; user saving ...");
    }

    public Long getUserDAOId() {
        return userDAOId;
    }

    public void setUserDAOId(Long userDAOId) {
        this.userDAOId = userDAOId;
    }
}
