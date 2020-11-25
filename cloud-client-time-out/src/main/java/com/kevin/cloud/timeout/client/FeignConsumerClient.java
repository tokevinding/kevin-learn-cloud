package com.kevin.cloud.timeout.client;

import com.kevin.cloud.timeout.client.fallback.FeignConsumerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kevin
 * @date 2020-11-23 16:10:35
 * @desc
 */
@FeignClient(value = "kevin-eurka-client", fallback = FeignConsumerFallback.class)
public interface FeignConsumerClient {
    @RequestMapping(value = "/kevin/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name", required = false) String name);

    @RequestMapping(value = "/kevin/timeOut", method = RequestMethod.GET)
    String toTimeOut();
}
