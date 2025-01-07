package com.mk.demo.mybatis.intercetors;

import com.mk.demo.mybatis.mapper.UserMapper;
import com.mk.demo.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * InterceptorTest
 *
 * @author WangChen
 * Created on 2025/1/7
 * @since 1.0
 */
public class InterceptorTest {

    public static void main(String[] args) throws IOException {
        Reader reader =
                Resources.getResourceAsReader("mybatis-config-plugins.xml");
        SqlSessionFactory sessionFactory
                = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();

        //传入StudentMapper接口，返回该接口的mapper代理对象studentMapper
        UserMapper userMapper = session.getMapper(UserMapper.class);//接口
        //通过mapper代理对象studentMapper，来调用IStudentMapper接口中的方法
        User user = userMapper.findById(2);
        System.out.println(user);
        session.close();
    }
}
