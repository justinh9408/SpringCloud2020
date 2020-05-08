package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: Justin
 */
@Slf4j
@RestController
public class OrderController {

    private static final String PAYMENT_HOST = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {

        return restTemplate.postForObject(PAYMENT_HOST + "/payment/create/", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/entity/create")
    public CommonResult<Payment> create2(Payment payment) {

        ResponseEntity<CommonResult> postForEntity = restTemplate.postForEntity(PAYMENT_HOST + "/payment/create/", payment, CommonResult.class);

        if (postForEntity.getStatusCode().is2xxSuccessful()) {

            return postForEntity.getBody();
        } else {

            return new CommonResult<Payment>(444,"错误",null);
        }


    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {

        return restTemplate.getForObject(PAYMENT_HOST + "/payment/get/" + id, CommonResult.class);

    }


    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {

        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_HOST + "/payment/get/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()) {

            return entity.getBody();
        } else {

            return new CommonResult<Payment>(444,"错误",null);
        }
    }
}
