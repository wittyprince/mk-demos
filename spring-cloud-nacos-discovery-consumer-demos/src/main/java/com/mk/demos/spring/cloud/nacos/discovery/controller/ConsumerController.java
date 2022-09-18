package com.mk.demos.spring.cloud.nacos.discovery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * consumer controller
 *
 * @author WangChen
 * Created on 2022/6/26
 * @since 1.0.0
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private String providerUrl = "http://cloud-discovery-provider/provider/provide";

    private final RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consume/{str}")
    public String consume(@PathVariable String str) {
        String forObject = restTemplate.getForObject(providerUrl + "/" + str, String.class);
        return "consume..." + forObject;
    }

    @GetMapping("/discoveryClient/consume/{str}")
    public String discoveryClient(@PathVariable String str) {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-discovery-provider");
        for (ServiceInstance instance : instances) {
            System.out.println("服务地址：" + instance.getUri());
            System.out.println("服务名称：" + instance.getServiceId());
        }
        String url = instances.get(0).getUri() + "/provider/provide";
        String callServiceResult = new RestTemplate().getForObject(url + "/" + str, String.class);
        return "consume..." + callServiceResult;
    }

    @GetMapping("/loadBalancerClient/consume/{str}")
    public String loadBalance(@PathVariable String str) {
        ServiceInstance instance = loadBalancer.choose("cloud-discovery-provider");
        System.out.println("服务地址：" + instance.getUri());
        System.out.println("服务名称：" + instance.getServiceId());
        String url = instance.getUri() + "/provider/provide";
        String callServiceResult = new RestTemplate().getForObject(url + "/" + str, String.class);
        return "consume..." + callServiceResult;
    }
}
