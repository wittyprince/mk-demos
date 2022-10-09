package com.mk.demos.spring.boot.test.dao;

import com.mk.demos.spring.boot.test.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * user mapper
 *
 * @author WangChen
 * Created on 2022/10/9
 * @since 1.0
 */
@Mapper
public interface UserInfoMapper {

    UserInfo findById(Long id);
}
