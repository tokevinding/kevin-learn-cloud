package com.kevin.cloud.client.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/kevin")
@Api
public class EurekaClientController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    @ApiOperation("client-测试获取配置")
    public String cloudHi(@RequestParam(value = "name", defaultValue = "kevin") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @Value("${api.time.out.ms:1000}")
    private Long timeOutMs;

    @GetMapping("/timeOut")
    @ApiOperation("设置睡眠接口")
    public String cloudHi() {
        try {
            Thread.sleep(timeOutMs);
        } catch (Throwable t) {
            System.out.println("接口睡眠异常！！！");
        }
        return "接口正常请求 port:" + port;
    }
}
