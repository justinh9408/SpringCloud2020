package com.atguigu.springcloud;

import com.atguigu.LbRule.CustomeRandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author: Justin
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = CustomeRandomRule.class)
public class ConsumerOrderApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(ConsumerOrderApplication.class, args);
    }
}
