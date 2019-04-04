package com.mk.demo.servlet.service.impl;

import java.util.List;

import com.mk.demo.servlet.dao.FlowerDao;
import com.mk.demo.servlet.dao.impl.FlowerDaoImpl;
import com.mk.demo.servlet.model.Flower;
import com.mk.demo.servlet.service.FlowerService;

/**
 * flower service impl
 * Created by WangChen on 2019/4/3 20:48.
 */
public class FlowerServiceImpl implements FlowerService {

    private FlowerDao flowerDao = new FlowerDaoImpl();

    @Override
    public List<Flower> listFlowers() {
        return flowerDao.listFlowers();
    }
}
