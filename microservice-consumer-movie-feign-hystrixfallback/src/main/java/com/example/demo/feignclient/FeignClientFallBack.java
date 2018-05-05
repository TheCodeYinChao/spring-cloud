package com.example.demo.feignclient;

import com.example.demo.vo.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 2018/5/5.
 */
@Component
public class FeignClientFallBack implements UserFeignClient {
    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User getByIdName(Long id, String name) {
        return null;
    }

    @Override
    public User findParams(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<User> getUsers(User user) {
        return null;
    }

    @Override
    public List<User> getUsersByStr(String param) {
        return null;
    }
}
