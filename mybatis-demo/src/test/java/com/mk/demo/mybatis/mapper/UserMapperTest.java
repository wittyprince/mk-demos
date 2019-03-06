package com.mk.demo.mybatis.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mk.demo.mybatis.po.User;

/**
 * user mapper test
 * Created by WangChen on 2019/1/27 19:53.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSave(){
        User user = new User();
        user.setName("WangChen");
//        user.setPassword("123123");
        userMapper.save(user);
    }

    @Test
    public void testFindById(){
        int id = 1;
        User user = userMapper.findById(id);
        System.out.println(user);
    }

}
