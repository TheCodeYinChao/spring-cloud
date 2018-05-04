package com.example.demo.feignclient;

import com.example.demo.vo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Admin on 2018/4/30.
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id")Long id);
}
