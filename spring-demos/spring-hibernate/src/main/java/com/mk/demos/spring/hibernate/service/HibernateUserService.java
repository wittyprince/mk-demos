package com.mk.demos.spring.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mk.demos.spring.hibernate.dao.HibernateUserDAO;
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

//    @Qualifier("hibernateUserDAOImpl")
    private HibernateUserDAO hibernateUserDAO;

    public void add(HibernateUser user){
        hibernateUserDAO.save(user);
    }

    @Transactional
    public void modifyUser(HibernateUser user){
        hibernateUserDAO.update(user);
    }

    @Transactional
    public void nestedOop(HibernateUser user){
        hibernateUserDAO.update(user);
        hibernateUserDAO.update2(user);
        throw new RuntimeException("service");
    }

    @Transactional
    public void templateAdd(HibernateUser user){
        hibernateUserDAO.templateSave(user);
    }





    @Autowired
    public void setHibernateUserDAO(HibernateUserDAO hibernateUserDAO) {
        this.hibernateUserDAO = hibernateUserDAO;
    }
}
