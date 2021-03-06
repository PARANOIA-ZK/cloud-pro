package com.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author PARANOIA_ZK
 * @date 2018/3/6 18:50
 */
//绑定服务
@FeignClient(value = "service-demo", fallback = FeignHelloServiceFallback.class)
public interface FeignHelloService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hi(@RequestParam("name") String name);

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    String getOne(@RequestParam("id") String id);

    @RequestMapping(value = "/minus", method = RequestMethod.GET)
    String minus(@RequestParam("xid") String id,@RequestParam("money") String money) ;
}
