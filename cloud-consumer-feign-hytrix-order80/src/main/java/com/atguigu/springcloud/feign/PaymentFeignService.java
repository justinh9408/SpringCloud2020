package com.atguigu.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/hystrix/ok")
    public String paymentOk();

    @GetMapping("/payment/hystrix/timeout")
    public String paymentTimeout();

}
