package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 2018/5/6.
 */
@RestController
public class ConfigClientController {
    @Value("${profile}")
    private String profile;

    @GetMapping("profile")
    public String hello(){
        return this.profile;
    }

}
