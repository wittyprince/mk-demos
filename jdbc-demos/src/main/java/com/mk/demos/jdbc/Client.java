package com.mk.demos.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用jdbc连接数据库
 *
 * @author WangChen
 * Created on 2021/1/21 17:36
 * @since 1.0
 */
public class Client {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://192.168.52.134:3306/mktest";
        String username = "wangchen";
        String password = "wangchen@123";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            // 1. 注册一个JDBC driver
            Class<?> aClass = Class.forName(driverClassName);
            // 2. 获取连接
            connection = DriverManager.getConnection(url, username, password);
            // 3. 准备查询语句
            String sql = "select * from people";
            preparedStatement = connection.prepareStatement(sql);
            // 4. 执行查询并获取结果
            rs = preparedStatement.executeQuery();
            // 5. 结果
            while (rs.next()){
                Long id = rs.getObject(1, Long.class);
                String name = rs.getString(2);
                System.out.println("id: " + id + ", name: " + name);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
                try {
                    if (rs != null){
                        rs.close();
                        rs = null;
                    }
                    if (preparedStatement != null){
                        preparedStatement.close();
                        preparedStatement = null;
                    }
                    if (connection != null){
                        connection.close();
                        connection = null;
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }

    }
}
