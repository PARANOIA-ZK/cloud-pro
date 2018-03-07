package com.consumer.service;

import org.springframework.stereotype.Component;

/**
 * @author PARANOIA_ZK
 * @date 2018/3/6 20:00
 */
@Component
public class FeignHelloServiceFallback implements FeignHelloService {

    @Override
    public String hi(String name) {
        return "fallback";
    }
}
