package com.mk.demos.tradition;

import org.junit.Test;

import com.mk.demos.tradition.model.User;
import com.mk.demos.tradition.service.UserService;

/**
 * UserService 测试类
 *
 * 在传统的编程模式中，userDAO是我们自己new出来的
 *                  userService也是我们自己new出来的
 *
 * @author WangChen
 * Created on 2021/1/9 14:09
 * @since 1.0
 */
public class UserServiceTest {

    private UserService userService;
    @Test
    public void testAdd(){
        // 注意这里userService是我们自己new出来的
        userService = new UserService();
        User user = new User();
        userService.add(user);
    }
}
