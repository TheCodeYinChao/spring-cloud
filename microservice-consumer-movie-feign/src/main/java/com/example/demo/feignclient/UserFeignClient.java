package com.example.demo.feignclient;

import com.example.demo.feign.FeignLogConfiguratiom;
import com.example.demo.vo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 2018/4/30.
 */
@FeignClient(name = "microservice-provider-user",configuration = FeignLogConfiguratiom.class)
public interface UserFeignClient {
    /**
     * 单独参数
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id")Long id);

    /**
     * 多参数1
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value="/getByIdName",method = RequestMethod.GET)
    public User getByIdName(@PathVariable("id")Long id,@PathVariable("name")String name);

    /**
     * 多参数2
     * @return
     */
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public User findParams(@RequestParam Map<String,Object> map);

    /**
     * 构造多参数实体
     * @param user
     * @return
     */
    @RequestMapping(value = "getUsers",method = RequestMethod.POST)
    public List<User> getUsers(@RequestBody User user);

    /**
     *Json 实体
     * @param param
     * @return
     */
    @RequestMapping(value = "getUsersByStr",method = RequestMethod.GET)
    public List<User> getUsersByStr(@RequestBody String param);


}
