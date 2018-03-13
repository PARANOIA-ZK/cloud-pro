package com.consumer.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author PARANOIA_ZK
 * @date 2018/3/6 20:00
 */
@Component
public class FeignHelloServiceFallback2 implements FeignHelloService2 {

    @Override
    public String hi(String name) {
        return "fallback";
    }

    @Override
    public String getOne(String id) {
        return "失败";
    }

    @Override
    public String add(@RequestParam("xid") String id, @RequestParam("money") String money) {
        return null;
    }
}
