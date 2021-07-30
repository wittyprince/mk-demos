package com.mk.demos.mapstruct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mk.demos.mapstruct.complex.expression.OneMapper;
import com.mk.demos.mapstruct.complex.expression.TaskDO;
import com.mk.demos.mapstruct.complex.expression.TaskVO;

/**
 * OneMapper test
 *
 * @author WangChen
 * Created on 2021/7/30 13:27
 * @since 0.1
 */
public class OneMapperTest {

    static OneMapper oneMapper;

    @BeforeAll
    public static void before(){
        oneMapper = OneMapper.INSTANCE;
    }

    @Test
    public void test1(){
        TaskDO taskDO = new TaskDO(1);

        TaskVO taskVO = oneMapper.toTaskVo(taskDO);

        System.out.println(taskVO);

        Assertions.assertNotNull(taskVO);
        Assertions.assertEquals("已完成", taskVO.getTaskStatusName());
    }
}
