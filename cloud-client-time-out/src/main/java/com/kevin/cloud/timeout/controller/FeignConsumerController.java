package com.kevin.cloud.timeout.controller;

import com.kevin.cloud.timeout.client.FeignConsumerClient;
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
public class FeignConsumerController {

    @Autowired
    private FeignConsumerClient feignConsumerClient;

    @GetMapping("/hi")
    public String cloudHi(@RequestParam(required = false) String name) {
        return feignConsumerClient.sayHiFromClientOne(name);
    }
    @GetMapping("/timeOut")
    public String timeOut() {
        return feignConsumerClient.toTimeOut();
    }
}
