package com.mk.demos.spring.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.mk.demos.spring.hibernate.dao.UserDAO;
import com.mk.demos.spring.hibernate.model.HibernateUser;

/**
 * 手动获取 SessionFactory 方式
 * @author WangChen
 * Created on 2021/1/20 16:59
 * @since 1.0
 */
@Repository("sessionFactoryUserDAO")
public class SessionFactoryUserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    public SessionFactoryUserDAOImpl(SessionFactory sessionFactory) {
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
    //TODO Hibernate transaction 委托给 Spring  ???
    // Hibernate Session objects are NOT thread-safe.
    public void update(HibernateUser user) {
        HibernateUser u = new HibernateUser();
        u.setId(user.getId());
        u.setName(user.getName() + "-" + user.getId());
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
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update2(HibernateUser user) {
        HibernateUser u =  new HibernateUser();
        u.setId(user.getId());
        u.setName(user.getName() + "2");
        Session session = sessionFactory.getCurrentSession();
        session.update(u);
//        throw new RuntimeException("2");
    }

    @Override
    public HibernateUser getById(Long id) {
        return null;
    }
}
