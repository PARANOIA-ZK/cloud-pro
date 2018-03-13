package com.service.controller;

import com.service.entity.Account;
import com.service.service.CountService;
import com.taobao.txc.common.TxcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CountService countService;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hi(@RequestParam("name") String name) {
        return "你好啊 ,：" + name;
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    String getOne(@RequestParam("id") String id) {
        int money = countService.getOne(Integer.valueOf(id)).getMoney();
        return String.valueOf(money);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String add(@RequestParam("xid") String id,@RequestParam("money") String money) {

        System.out.println("id = " + id);
        System.out.println("money = " + money);

        int addMoney = Integer.parseInt(money);
        TxcContext.bind(id, null);
        int totalMoney = countService.getOne(1).getMoney();
        Account account = new Account();
        account.setId(1);
        account.setMoney(totalMoney + addMoney);
        countService.update(account);
        TxcContext.unbind();
        return "1";
    }


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
