package com.mk.demos.spring.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mk.demos.spring.hibernate.dao.AccountDAO;
import com.mk.demos.spring.hibernate.model.HibernateAccount;

/**
 * account service
 *
 * @author WangChen
 * Created on 2021/4/19 16:36
 * @since 1.0
 */
@Service
public class AccountService {

    @Autowired
    @Qualifier("templateAccountDAO")
    private AccountDAO accountDAO;

    @Transactional
    public void modify(HibernateAccount account){
        accountDAO.update(account);
//        throw new RuntimeException("xxx");
    }
}
