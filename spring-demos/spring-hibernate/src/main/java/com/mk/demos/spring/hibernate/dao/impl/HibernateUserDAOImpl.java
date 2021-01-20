package com.mk.demos.spring.hibernate.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mk.demos.spring.hibernate.dao.HibernateUserDAO;
import com.mk.demos.spring.hibernate.model.HibernateUser;

/**
 * @author WangChen
 * Created on 2021/1/20 16:59
 * @since 1.0
 */
@Repository
public class HibernateUserDAOImpl implements HibernateUserDAO {

    private final SessionFactory sessionFactory;

    public HibernateUserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(HibernateUser user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
//    @Transactional(propagation = Propagation.NESTED)
    public void update(HibernateUser user) {
        HibernateUser u = new HibernateUser();
        u.setId(user.getId());
        u.setName(user.getName() + "1");
        Session session = sessionFactory.getCurrentSession();
        session.update(u);
//        throw new RuntimeException("1");
    }

    /**
     * Propagation.REQUIRES_NEW: 总是产生新的事务。内外层事务独立。
     *                          外层事务不能回滚内部事务，但内层事务会回滚外层事务。
     * Propagation.NESTED:      外层事务可以回滚内部事务，内层事务是外部事务的一部分。
     *                          外部事务提交时才会把内部事务一并提交。
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update2(HibernateUser user) {
        HibernateUser u =  new HibernateUser();
        u.setId(user.getId());
        u.setName(user.getName() + "2");
        Session session = sessionFactory.getCurrentSession();
        session.update(u);
//        throw new RuntimeException("2");
    }

    // ====================================================
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void templateSave(HibernateUser user) {
        hibernateTemplate.save(user);
    }
}
