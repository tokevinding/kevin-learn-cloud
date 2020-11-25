package com.kevin.cloud.sleuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author kevin
 * @date 2020-11-23 14:50:29
 * @desc
 */
@Service
public class SleuthConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://kevin-eurka-client/kevin/hi?name="+name,String.class);
    }
}
