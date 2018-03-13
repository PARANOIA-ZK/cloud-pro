package com.consumer.controller;

import com.consumer.service.FeignHelloService;
import com.consumer.service.FeignHelloService2;
import com.consumer.service.FeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author PARANOIA_ZK
 * @date 2018/3/6 18:58
 */
@Controller
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    FeignService feignService;

    //@RequestMapping(value = "sayHi", method = RequestMethod.GET)
    //@ResponseBody
    //public String sayHi(@RequestParam(value = "name") String name) {
    //    String result = feignHelloService.hi(name);
    //    logger.info("服务消费者得到的结果：" + result);
    //    return result;
    //}

    @RequestMapping(value = "pay", method = RequestMethod.GET)
    public String pay(ModelMap map) {
        String one = feignService.getOne("1");
        String two = feignService.getTwo("1");
        map.addAttribute("accountA", one);
        map.addAttribute("accountB", two);
        return "pay";
    }

    @RequestMapping(value="/tranferAcc",method= RequestMethod.GET)
    public String helloConsumer(HttpServletRequest request, HttpServletResponse response, ModelMap map)  {

        String money = request.getParameter("money");
        try {
            feignService.transfer(money);
        }
        catch (Exception e ) {
            e.printStackTrace();
            map.addAttribute("errinfo", "余额不足转账失败，GTS事务已回滚");
        }
        String one = feignService.getOne("1");
        String two = feignService.getTwo("1");
        map.addAttribute("accountA", one);
        map.addAttribute("accountB", two);
        return "pay";

    }
}
