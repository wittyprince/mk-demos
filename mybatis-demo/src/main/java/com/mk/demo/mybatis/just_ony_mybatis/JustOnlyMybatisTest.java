package com.mk.demo.mybatis.just_ony_mybatis;

import com.mk.demo.mybatis.mapper.UserMapper;
import com.mk.demo.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.Reader;

/**
 * JustOnlyMybatisTest
 *
 * @author WangChen
 * Created on 2024/11/27
 * @since 1.0
 */
public class JustOnlyMybatisTest {
    // 仅仅使用mybatis自身来操作数据库
    public static void main(String[] args) throws IOException {
        instanceMybatisByXml();
        instanceMybatisByJava();
    }

    private static void instanceMybatisByJava() {
        DataSource dataSource = null; //BlogDataSourceFactory.getBlogDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        org.apache.ibatis.session.Configuration configuration = new Configuration(environment);
        // 由于 Java 注解的一些限制以及某些 MyBatis 映射的复杂性，要使用大多数高级映射（比如：嵌套联合映射），仍然需要使用 XML 映射文件进行映射。
        // 有鉴于此，如果存在一个同名 XML 映射文件，MyBatis 会自动查找并加载它（在这个例子中，基于类路径和 BlogMapper.class 的类名，会加载 BlogMapper.xml）。
        configuration.addMapper(UserMapper.class);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("com.mk.demo.mybatis.mapper.UserMapper.findById", 1);
        System.out.println(user);
        sqlSession.close();
    }

    private static void instanceMybatisByXml() throws IOException {
        // 方式一：使用xml方式配置
        String resource = "com/mk/demo/mybatis/just_ony_mybatis/mybatis_config.xml";
        Reader reader = org.apache.ibatis.io.Resources.getResourceAsReader(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("com.mk.demo.mybatis.mapper.UserMapper.findById", 1);
//        User byId = sqlSession.getMapper(UserMapper.class).findById(1);// 通过接口的方式获取mapper对象
        System.out.println(user);
        sqlSession.close();
    }

}
