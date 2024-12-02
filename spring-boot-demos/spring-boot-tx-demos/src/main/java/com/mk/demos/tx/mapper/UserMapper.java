package com.mk.demos.tx.mapper;

import com.mk.demos.tx.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * user mapper
 * Created by WangChen on 2019/1/27 19:45.
 */
@Mapper
public interface UserMapper {

    void save(User user);

    User findById(int id);
}
