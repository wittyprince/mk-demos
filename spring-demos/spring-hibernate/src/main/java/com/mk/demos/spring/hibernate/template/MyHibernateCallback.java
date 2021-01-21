package com.mk.demos.spring.hibernate.template;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * 模拟HibernateCallback
 *
 * @author WangChen
 * Created on 2021/1/20 19:40
 * @since 1.0
 */
public interface MyHibernateCallback {

    Object doInHibernate(Session session) throws RuntimeException;
}
