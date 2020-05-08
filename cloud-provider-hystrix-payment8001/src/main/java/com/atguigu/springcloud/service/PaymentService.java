package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: Justin
 */
@Service
@Slf4j
public class PaymentService {

    public String payment_OK() {

        log.info(Thread.currentThread().getName() + " payment_OK");

        return Thread.currentThread().getName() + " payment_OK";
    }

    @HystrixCommand(fallbackMethod = "payment_timeout_handler", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="12000")
    })
    public String payment_timeout() {

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        log.info(Thread.currentThread().getName() + " payment_timeout");

        return Thread.currentThread().getName() + " payment_timeout";
    }

    public String payment_timeout_handler() {

        return Thread.currentThread().getName() + "降级 payment_timeout_handler";
    }
}
