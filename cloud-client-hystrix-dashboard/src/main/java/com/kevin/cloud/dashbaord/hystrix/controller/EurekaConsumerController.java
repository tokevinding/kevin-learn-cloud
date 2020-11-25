package com.kevin.cloud.dashbaord.hystrix.controller;

import com.kevin.cloud.dashbaord.hystrix.service.EurekaConsumerService;
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
public class EurekaConsumerController {

    @Autowired
    private EurekaConsumerService consumerService;

    @GetMapping("/hi")
    public String cloudHi(@RequestParam(required = false) String name) {
        return consumerService.hiService(name);
    }
}
