package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: Justin
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("create payment:{}",payment);
        int result = paymentService.create(payment);
        log.info("result: {}", result);
        if (result > 0) {
            return new CommonResult(200, "success", result);
        } else {
            return new CommonResult(444, "error", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        log.info("get payment: {}", id);
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("returned result: {}", paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "success2", paymentById);
        } else {
            return new CommonResult(404, "not found", null);
        }
    }

}
