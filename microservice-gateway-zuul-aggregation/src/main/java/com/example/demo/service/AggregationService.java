package com.example.demo.service;

import com.example.demo.vo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;


/**
 * Created by Admin on 2018/5/5.
 */
@Service
public class AggregationService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserById(Long id){
        return Observable.create(observer ->{
            User user = restTemplate.getForObject("http://microservice-provider-user/{id}",User.class,id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }
    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getMovidUserByUserId(Long id){
        return Observable.create(observer ->{
            User user = restTemplate.getForObject("http://microservice-provider-user/{id}",User.class,id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }


    public User fallback(Long id){
        User user = new User();
        user.setId(-1l);
        return user;
    }
}
