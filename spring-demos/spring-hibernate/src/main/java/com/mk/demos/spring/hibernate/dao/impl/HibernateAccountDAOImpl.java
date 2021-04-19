package com.mk.demos.spring.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mk.demos.spring.hibernate.dao.HibernateAccountDAO;
import com.mk.demos.spring.hibernate.model.HibernateAccount;
import com.mk.demos.spring.hibernate.model.HibernateUser;

/**
 * HibernateAccountDAO impl
 *
 * @author WangChen
 * Created on 2021/4/19 15:12
 * @since 1.0
 */
public class HibernateAccountDAOImpl implements HibernateAccountDAO {

    private final SessionFactory sessionFactory;

    public HibernateAccountDAOImpl(SessionFactory sessionFactory) {
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
