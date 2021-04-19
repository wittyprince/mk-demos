package com.mk.demos.spring.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mk.demos.spring.hibernate.dao.UserDAO;
import com.mk.demos.spring.hibernate.model.HibernateUser;

/**
 * user service
 *
 * @author WangChen
 * Created on 2021/1/20 17:05
 * @since 1.0
 */
@Service
public class HibernateUserService {

    @Autowired
    @Qualifier("sessionFactoryUserDAO")
    private UserDAO sessionFactoryUserDAO;

    @Autowired
    @Qualifier("templateUserDAO")
    private UserDAO templateUserDAO;

    @Transactional
    public void add(HibernateUser user){
        templateUserDAO.save(user);
    }

    @Transactional
    public void modifyUser(HibernateUser user){
        templateUserDAO.update(user);

        HibernateUser user2 = new HibernateUser();
        user2.setId(2L);
        user2.setName("h2");
        this.modifyUser2(user2);
    }
    @Transactional
    public void modifyUser2(HibernateUser user){
        templateUserDAO.update(user);
    }

    @Transactional
    public void nestedOop(HibernateUser user){
        templateUserDAO.update(user);
        templateUserDAO.update2(user);
//        throw new RuntimeException("service");
    }

//    @Transactional
    public HibernateUser findById(Long id){
        return templateUserDAO.getById(id);
    }


}
