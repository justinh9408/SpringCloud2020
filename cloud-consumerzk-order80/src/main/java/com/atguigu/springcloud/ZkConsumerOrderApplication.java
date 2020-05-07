package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: Justin
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkConsumerOrderApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZkConsumerOrderApplication.class, args);
    }
}
