package com.mk.demos.spring.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mk.demos.spring.hibernate.dao.AccountDAO;
import com.mk.demos.spring.hibernate.model.HibernateAccount;

/**
 * HibernateAccountDAO impl
 *
 * @author WangChen
 * Created on 2021/4/19 15:12
 * @since 1.0
 */
@Repository("sessionFactoryAccountDAOImpl")
public class SessionFactoryAccountDAOImpl implements AccountDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public SessionFactoryAccountDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(HibernateAccount account) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(HibernateAccount account) {
        HibernateAccount acc = new HibernateAccount();
        acc.setId(account.getId());
        acc.setName(account.getName() + "-" + account.getId());
        Session session = sessionFactory.getCurrentSession();
        session.update(acc);
    }
}
