package com.mk.demos.mybatis.mapper;

import com.mk.demos.mybatis.model.User;
import io.mybatis.mapper.Mapper;

/**
 * UserMapper
 *
 * @author WangChen
 * Created on 2023/5/5
 * @since 1.0
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User, Long> {

}
