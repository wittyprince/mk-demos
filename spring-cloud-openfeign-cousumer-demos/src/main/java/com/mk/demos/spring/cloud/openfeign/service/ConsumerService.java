package com.mk.demos.spring.cloud.openfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * consumer service
 *
 * @author WangChen
 * Created on 2022/6/24
 * @since 1.0.0
 */
@Service
@FeignClient(value = "cloud-provider", url = "http://localhost:9001/")
public interface ConsumerService {

    @PostMapping("/provider/provide")
    Object consume();

}
