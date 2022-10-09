package com.mk.demos.spring.boot.test.dao;

import com.mk.demos.spring.boot.test.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * user mapper test
 *
 * @author WangChen
 * Created on 2022/10/9
 * @since 1.0
 */
@SpringBootTest
@ActiveProfiles("test") //指定激活的profile
public class UserMapperTest {

    @Autowired
    private UserInfoMapper userMapper;

    @Test
    public void testSelect(){
        UserInfo user = userMapper.findById(1L);
        assertEquals("Jone", user.getName());
    }
}
