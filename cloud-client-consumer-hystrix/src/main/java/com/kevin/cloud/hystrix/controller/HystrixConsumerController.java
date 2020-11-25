package com.kevin.cloud.hystrix.controller;

import com.kevin.cloud.hystrix.service.HystrixConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin
 * @date 2020-11-23 14:50:29
 * @desc
 */
@RestController
@RequestMapping("/kevin/consumer")
public class HystrixConsumerController {

    @Autowired
    private HystrixConsumerService consumerService;

    @GetMapping("/hi")
    public String cloudHi(@RequestParam(required = false) String name) {
        return consumerService.hiService(name);
    }
}
