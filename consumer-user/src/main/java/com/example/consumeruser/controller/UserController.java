package com.example.consumeruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 当调用buy请求买票的时候会通过RestTemplate发送http请求去服务中根据指定的应用和服务提供的请求
     * 调用服务
     */
    @GetMapping("/buy")
    public String buyTicket(String name){
        //请求的url格式：
        //http://服务中心注册的Application用，也就是在yml中配置的应用名/调用服务中的哪个请求
        String str = restTemplate.getForObject("http://PROVIDER-TICKET/ticket",
                String.class);
        return name+":购买了 "+str;
    }
}
