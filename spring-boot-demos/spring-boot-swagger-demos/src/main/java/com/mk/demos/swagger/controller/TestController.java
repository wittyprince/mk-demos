package com.mk.demos.swagger.controller;

import com.mk.demos.swagger.vo.TestVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SwaggerTestController
 *
 * @author WangChen
 * Created on 2023/5/18
 * @since 1.0
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/api")
public class TestController {

    @ApiOperation(value = "通过ID获取")
    @GetMapping("/{id}")
    public TestVO get(@PathVariable String id){
        return new TestVO("name: " + id);
    }

}
