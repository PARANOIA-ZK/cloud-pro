package com.consumer.controller;

import com.consumer.service.FeignHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PARANOIA_ZK
 * @date 2018/3/6 18:58
 */
@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    FeignHelloService feignHelloService;

    @RequestMapping(value = "sayHi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "name") String name) {
        String result = feignHelloService.hi(name);
        logger.info("服务消费者得到的结果：" + result);
        return result;
    }
}
