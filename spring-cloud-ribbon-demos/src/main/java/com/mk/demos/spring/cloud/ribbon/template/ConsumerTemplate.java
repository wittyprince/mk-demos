package com.mk.demos.spring.cloud.ribbon.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * template
 *
 * @author WangChen
 * Created on 2022/6/24
 * @since 1.0.0
 */
@Slf4j
@Component
public class ConsumerTemplate {

//    String url = "http://localhost:9001/";
    String url = "http://cloud-provider";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;


    public String consume() {
        System.out.println("loadBalancer: {}" + loadBalancer);

        return restTemplate.postForObject(url + "/provider/provide", null, String.class);
    }
}
