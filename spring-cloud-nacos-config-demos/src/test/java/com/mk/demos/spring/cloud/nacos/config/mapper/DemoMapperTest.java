package com.mk.demos.spring.cloud.nacos.config.mapper;

import com.mk.demos.spring.cloud.nacos.config.dao.UserInfoMapper;
import com.mk.demos.spring.cloud.nacos.config.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * demo mapper test
 *
 * @author WangChen
 * Created on 2022/10/11
 * @since 1.0
 */
@SpringBootTest
@ActiveProfiles("testing") //指定激活的profile
public class DemoMapperTest {

    @Autowired
    private UserInfoMapper userMapper;

    @Test
    public void testSelect(){
        UserInfo user = userMapper.findById(1L);
        assertEquals("Jone", user.getName());
    }
}
