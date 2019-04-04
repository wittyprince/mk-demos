package com.mk.demo.servlet.service;

import java.util.List;

import org.junit.Test;

import com.mk.demo.servlet.model.Flower;
import com.mk.demo.servlet.service.impl.FlowerServiceImpl;

/**
 * flower service test
 * Created by WangChen on 2019/4/3 20:51.
 */
public class FlowerServiceTest {

    private FlowerService flowerService = new FlowerServiceImpl();

    @Test
    public void testListFlowers(){
        List<Flower> flowers = flowerService.listFlowers();
        for (Flower flower : flowers){
            System.out.println(flower.getName());
        }

    }
}
