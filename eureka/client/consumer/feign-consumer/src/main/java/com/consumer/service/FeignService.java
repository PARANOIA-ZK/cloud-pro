package com.consumer.service;

import com.taobao.txc.client.aop.annotation.TxcTransaction;
import com.taobao.txc.common.TxcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

/**
 * @author PARANOIA_ZK
 * @date 2018/3/12 21:21
 */
@Repository
public class FeignService {

    @Autowired
    FeignHelloService feignHelloService;

    @Autowired
    FeignHelloService2 feignHelloService2;

    public String getOne(String id){
        return feignHelloService.getOne(id);
    }

    public String getTwo(String id){
        return feignHelloService2.getOne(id);
    }

    @TxcTransaction(timeout = 1000 * 6)
    public void transfer(String money){
        String xid = TxcContext.getCurrentXid();

        //加
        feignHelloService2.add(xid,money);

        //减
        String result = feignHelloService.minus(xid,money);

        System.out.println("减法result = " + result);

        if ("-1".equals(result)) {
            throw new RuntimeException("转账失败");
        }
    }

}
