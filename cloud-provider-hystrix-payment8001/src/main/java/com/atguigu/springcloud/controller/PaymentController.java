package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Justin
 */
@RestController()
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @GetMapping("/hystrix/ok")
    public String paymentOk() {

        return paymentService.payment_OK();
    }


    @GetMapping("/hystrix/timeout")
    public String paymentTimeout() {

        return paymentService.payment_timeout();
    }
}
