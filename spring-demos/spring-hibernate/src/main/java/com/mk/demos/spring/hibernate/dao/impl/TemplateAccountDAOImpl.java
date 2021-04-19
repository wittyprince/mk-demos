package com.mk.demos.spring.hibernate.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mk.demos.spring.hibernate.dao.AccountDAO;
import com.mk.demos.spring.hibernate.model.HibernateAccount;

/**
 * template 实现方式
 *
 * @author WangChen
 * Created on 2021/4/19 16:44
 * @since 1.0
 */
@Repository("templateAccountDAO")
public class TemplateAccountDAOImpl implements AccountDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(HibernateAccount account) {
        hibernateTemplate.save(account);
    }

    @Override
    public void update(HibernateAccount account) {
        hibernateTemplate.update(account);
    }

}
