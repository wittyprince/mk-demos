package com.mk.demos.tx.service;

import com.mk.demos.tx.mapper.UserMapper;
import com.mk.demos.tx.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * UserService
 *
 * @author WangChen
 * Created on 2024/12/1
 * @since 1.0
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Transactional
    public void save(User user){
        System.out.println("save user");
        userMapper.save(user);
        throw new RuntimeException("save user exception");
    }

    public void findById(Integer id){
        System.out.println("find user by id");
        User byId = userMapper.findById(id);
        System.out.println(byId);
    }


    // 注意此处调用了save方法，save方法上有@Transactional注解，
    // 但是此种情况下，事务不会生效，因为事务是基于代理实现的，而在同一个类中调用方法，是不会走代理的
    // 所以此处的save方法不会走代理，所以事务不会生效
    // 如果要使事务生效，需要将save方法放到另一个类中，然后通过调用另一个类的方法来实现
    // 或者通过注入ApplicationContext来获取代理对象，然后调用代理对象的方法
    // 或者通过AopContext.currentProxy()获取代理对象，然后调用代理对象的方法
    // 或者通过注入UserService对象，然后调用UserService对象的方法
    // 所以此处的save方法会保存user对象，即使有异常抛出，也会保存user对象
    public void testTransactional(User user){
        this.save(user);
    }

    // 此处的save方法不会会保存user对象，因为有异常抛出，
    // 默认的事务传播行为是REQUIRED，即如果当前存在事务，则加入该事务，如果不存在事务，则新建一个事务
    // 所以此处的save方法会新建一个事务，然后save方法的事务会加入到本事务中
    // 抛出异常，所以不会保存user对象
    @Transactional
    public void testTransactionalWithTransactionalAnnotation(User user){
        this.save(user);
    }
}
