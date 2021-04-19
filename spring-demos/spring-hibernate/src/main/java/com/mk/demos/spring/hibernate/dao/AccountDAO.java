package com.mk.demos.spring.hibernate.dao;

import com.mk.demos.spring.hibernate.model.HibernateAccount;

/**
 * account dao
 *
 * @author WangChen
 * Created on 2021/4/19 15:10
 * @since 1.0
 */
public interface AccountDAO {

    void save(HibernateAccount account);

    void update(HibernateAccount account);
}
