package com.mk.demo.servlet.dao;

import java.util.List;

import org.junit.Test;

import com.mk.demo.servlet.dao.impl.FlowerDaoImpl;
import com.mk.demo.servlet.model.Flower;

/**
 * Created by WangChen on 2019/4/2 23:05.
 */
public class FlowerDaoTest {

    FlowerDao flowerDao = new FlowerDaoImpl();
    @Test
    public void testListFlowers(){
        List<Flower> flowers = flowerDao.listFlowers();
        for (Flower flower : flowers){
            System.out.println(flower.getName());
        }
    }
}
