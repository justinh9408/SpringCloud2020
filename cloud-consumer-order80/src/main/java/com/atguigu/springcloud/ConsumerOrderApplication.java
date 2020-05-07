package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: Justin
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerOrderApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerOrderApplication.class, args);
    }
}
