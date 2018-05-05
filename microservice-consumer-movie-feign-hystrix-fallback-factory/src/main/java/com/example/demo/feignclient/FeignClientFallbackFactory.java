package com.example.demo.feignclient;

import com.example.demo.vo.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 2018/5/5.
 */
@Component
@Slf4j
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{
    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                log.info("fallback; reason was:",cause.getMessage());
                User user = new User();


                if(cause instanceof IllegalArgumentException){
                    user.setId(-1L);
                }else{
                    user.setId(-2L);
                }
                user.setUsername("默认用户");
                return user;
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
        };
    }
}
