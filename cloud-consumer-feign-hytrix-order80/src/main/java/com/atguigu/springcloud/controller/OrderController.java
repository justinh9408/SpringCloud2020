package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.feign.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Justin
 */
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "global_fallback_handler")
public class OrderController {

    @Autowired
    PaymentFeignService feignService;

    @GetMapping("/payment/hystrix/ok")
    public String paymentOk(){

        return feignService.paymentOk();
    }

//    @HystrixCommand(fallbackMethod = "payment_timeout_handler", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
//    })
    @HystrixCommand
    @GetMapping("/payment/hystrix/timeout")
    public String paymentTimeout(){
        int i = 10 / 0;
        return feignService.paymentTimeout();
    }

    public String payment_timeout_handler() {

        return "time out from client order side";
    }

    public String global_fallback_handler() {

        return "global_fallback_handler";
    }
}
