package com.mk.demos.spring.hibernate.dao.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mk.demos.spring.hibernate.dao.UserDAO;
import com.mk.demos.spring.hibernate.model.HibernateUser;

/**
 * HibernateTemplate实现方式
 *
 * @author WangChen
 * Created on 2021/4/19 15:43
 * @since 1.0
 */
@Repository("templateUserDAO")
public class TemplateUserDAOImpl implements UserDAO {

    // ====================================================
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(HibernateUser user) {
        Serializable save = hibernateTemplate.save(user);
    }

    @Override
    public HibernateUser getById(Long id) {
        // load load: 返回的是一个代理对象，如果直接返回给jsp页面，会报session过期的问题，可以使用OpenSessionInView拦截器解决
        // com.mk.demos.spring.hibernate.model.HibernateUser$HibernateProxy$WNXoVrdv
//        HibernateUser user = hibernateTemplate.load(HibernateUser.class, id);

        // get: 返回的不是代理对象，返回给jsp页面不会有问题
        HibernateUser user = hibernateTemplate.get(HibernateUser.class, id);
        return user;
    }

    @Override
    public void update(HibernateUser user) {
        hibernateTemplate.update(user);
    }

    @Override
    public void update2(HibernateUser user) {
        hibernateTemplate.update(user);
    }
}
