package com.kevin.cloud.timeout.client.fallback;

import com.kevin.cloud.timeout.client.FeignConsumerClient;
import org.springframework.stereotype.Component;

/**
 * @author kevin
 * @date 2020-11-23 16:30:51
 * @desc
 */
@Component
public class FeignConsumerFallback implements FeignConsumerClient {
    @Override
    public String sayHiFromClientOne(String name) {
        return "调用服务失败-feign";
    }

    @Override
    public String toTimeOut() {
        return "调用服务失败-接口请求超时";
    }
}
