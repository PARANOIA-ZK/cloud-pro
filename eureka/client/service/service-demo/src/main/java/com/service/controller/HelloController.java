package com.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PARANOIA_ZK
 * @date 2018/3/6 18:46
 */
@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hi(@RequestParam("name") String name) {
        return "你好啊 ,：" + name;
    }

    ;

    //@Override
    //public String hi(String name) {
    //
    //    int sleepTime = new Random().nextInt(3000);
    //    logger.info("sleepTime:" + sleepTime);
    //    try {
    //        Thread.sleep(sleepTime);
    //    } catch (InterruptedException e) {
    //        e.printStackTrace();
    //    }
    //    return "你好啊，" + name;
    //}
}
