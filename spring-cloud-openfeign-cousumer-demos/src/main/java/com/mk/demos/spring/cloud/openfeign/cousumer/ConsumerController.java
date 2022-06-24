package com.mk.demos.spring.cloud.openfeign.cousumer;

import com.mk.demos.spring.cloud.openfeign.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * cousumer
 *
 * @author WangChen
 * Created on 2022/6/24
 * @since 1.0.0
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/consume")
    @ResponseBody
    public String consume() {
        Object consume = consumerService.consume();
        return "call..." + consume;
    }
}
