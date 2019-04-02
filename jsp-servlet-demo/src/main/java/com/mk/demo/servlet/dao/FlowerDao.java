package com.mk.demo.servlet.dao;

import java.util.List;

import com.mk.demo.servlet.model.Flower;

/**
 * flower dao
 * Created by WangChen on 2019/4/2 22:48.
 */
public interface FlowerDao {

    List<Flower> listFlowers();
}
