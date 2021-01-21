package com.mk.demos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc 模板方法
 *
 * @author WangChen
 * Created on 2021/1/21 19:21
 * @since 1.0
 */
public class JdbcTemplate {

    public static void main(String [] args){
        new JdbcTemplate().save("insert into people values(null, '八爷')");
        new JdbcTemplate().query("select * from people");
    }

    public void save(String sql){
        this.execute(sql, new PrepareStatementCallback() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException {
                ps.execute();
                return null;
            }
        });
    }

    public Object query(String sql){

        this.execute(sql, new PrepareStatementCallback() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException {
                // 4. 执行查询并获取结果
                ResultSet rs = ps.executeQuery();
                // 5. 结果
                while (rs.next()){
                    Long id = rs.getObject(1, Long.class);
                    String name = rs.getString(2);
                    System.out.println("id: " + id + ", name: " + name);
                }

                //TODO close rs
                return null;
            }
        });

        return null;
    }

    public void update(){

    }

    public void delete(){

    }

    public Object execute(String sql, PrepareStatementCallback callback){

        String driverClassName = "com.mysql.cj.jdbc.Driver";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            // 1. 注册一个JDBC driver
            Class<?> aClass = Class.forName(driverClassName);
            // 2. 获取连接
            connection = getConnect();
            preparedStatement = connection.prepareStatement(sql);
            // callback operate
            callback.doInPreparedStatement(preparedStatement);

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

        return null;
    }

    private Connection getConnect() throws SQLException {
        String url = "jdbc:mysql://192.168.52.134:3306/mktest";
        String username = "wangchen";
        String password = "wangchen@123";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
