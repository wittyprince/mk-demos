package com.mk.demo.servlet.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mk.demo.servlet.dao.FlowerDao;
import com.mk.demo.servlet.model.Flower;

/**
 * flower dao impl
 * Created by WangChen on 2019/4/2 22:53.
 */
public class FlowerDaoImpl implements FlowerDao {

    @Override
    public List<Flower> listFlowers() {
        List<Flower> flowerList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.52.134:3306/mybatis01", "wangchen", "wangchen@123");
            preparedStatement = connection.prepareStatement("SELECT * FROM flower");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                String production = resultSet.getString(4);
                Flower flower = new Flower();
                flower.setId(id);
                flower.setName(name);
                flower.setPrice(price);
                flower.setProduction(production);
                flowerList.add(flower);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flowerList;
    }
}
