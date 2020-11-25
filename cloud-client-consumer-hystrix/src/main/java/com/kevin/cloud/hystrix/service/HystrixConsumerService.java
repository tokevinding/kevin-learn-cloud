package com.kevin.cloud.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author kevin
 * @date 2020-11-23 14:50:29
 * @desc
 */
@Service
public class HystrixConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://kevin-eurka-client-1/kevin/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        return "调用服务失败-Hystrix";
    }
}
