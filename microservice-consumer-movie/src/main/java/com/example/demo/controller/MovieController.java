package com.example.demo.controller;

import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Admin on 2018/4/29.
 */
@RestController
public class MovieController {
    @Value("${api.user.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("user/{id}")
    public User findById(@PathVariable Long id){
        return restTemplate.getForObject(url+id,User.class);
    }
}
