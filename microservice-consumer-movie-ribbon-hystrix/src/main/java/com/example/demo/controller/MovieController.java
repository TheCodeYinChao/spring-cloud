package com.example.demo.controller;

import com.example.demo.vo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Admin on 2018/4/29.
 */
@RestController
@Slf4j
public class MovieController {
    @Value("${api.user.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("user/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy",value = "SEMAPHORE")//指定隔离策略 1线程隔离 2 信号量隔离（负载高）
    })
    public User findById(@PathVariable Long id){
        return restTemplate.getForObject("http://microservice-provider-user/"+id,User.class);
    }

    @GetMapping("log-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        log.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());

    }

    public User findByIdFallback(Long id){
        User user = new User();
        user.setId(0L);
        user.setUsername("默认用户");
        return user;
    }
}
