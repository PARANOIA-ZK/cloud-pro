package com.serviceapi.demo.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author PARANOIA_ZK
 * @date 2018/3/6 18:34
 */
@RequestMapping("/service")
public interface HelloService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hi(@RequestParam("name") String name);

}
