package com.mk.demos.spring.hibernate.dao;

import com.mk.demos.spring.hibernate.model.HibernateUser;

/**
 * hibernate user
 *
 * @author WangChen
 * Created on 2021/1/20 16:58
 * @since 1.0
 */
public interface UserDAO {

    void save(HibernateUser user);

    void update(HibernateUser user);

    public void update2(HibernateUser user);

//    public void templateSave(HibernateUser user);

    HibernateUser getById(Long id);
}
