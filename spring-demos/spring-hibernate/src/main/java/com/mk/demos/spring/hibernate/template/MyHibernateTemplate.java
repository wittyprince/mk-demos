package com.mk.demos.spring.hibernate.template;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 模拟HibernateTemplate
 *
 * @author WangChen
 * Created on 2021/1/20 19:39
 * @since 1.0
 */
public class MyHibernateTemplate {

    private SessionFactory sessionFactory;


    public Object save(Object entity) {
        new MyHibernateTemplate().executeWithNativeSession(new MyHibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws RuntimeException {
                session.save(entity);
                return null;
            }
        });
        return null;
    }

    public void update(Object entity){
        new MyHibernateTemplate().executeWithNativeSession(new MyHibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws RuntimeException {
                session.update(entity);
                return null;
            }
        });
    }

    Object executeWithNativeSession(MyHibernateCallback callback) {
        Session s = null;
        try {
            s = getSession();
            s.beginTransaction();

            callback.doInHibernate(s);

            s.getTransaction().commit();
        } catch (RuntimeException e) {
            s.getTransaction().rollback();
        } finally {
            if (s != null) {
                s.close();
                s = null;
            }
        }

        return null;
    }

    private Session getSession() {
        return null;
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
