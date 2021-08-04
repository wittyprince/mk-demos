package com.mk.demos.mapstruct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mk.demos.mapstruct.complex.decoretor.DecorateMapper;
import com.mk.demos.mapstruct.complex.expression.TaskDO;
import com.mk.demos.mapstruct.complex.expression.TaskVO;

/**
 * DecorateMapper test
 *
 * @author WangChen
 * Created on 2021/8/4 16:42
 * @since 0.1
 */
public class DecorateMapperTest {

    @Test
    public void test1(){
        DecorateMapper mapper = DecorateMapper.INSTANCE;
        TaskDO taskDO = new TaskDO(0);
        TaskVO taskVO = mapper.toTaskVo(taskDO);

        System.out.println(taskVO);

        Assertions.assertNotNull(taskVO);
        Assertions.assertEquals("未完成", taskVO.getTaskStatusName());
    }
}
