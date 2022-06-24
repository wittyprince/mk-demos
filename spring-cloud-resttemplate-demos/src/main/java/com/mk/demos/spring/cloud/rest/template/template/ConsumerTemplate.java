package com.mk.demos.spring.cloud.rest.template.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * template
 *
 * @author WangChen
 * Created on 2022/6/24
 * @since 1.0.0
 */
@Component
public class ConsumerTemplate {

    String url = "http://localhost:9001/";

    @Autowired
    private RestTemplate restTemplate;


    public String consume() {
        return restTemplate.postForObject(url + "/provider/provide", null, String.class);
    }
}
