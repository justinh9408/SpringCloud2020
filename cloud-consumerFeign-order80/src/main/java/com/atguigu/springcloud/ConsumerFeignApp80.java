package com.atguigu.springcloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author: Justin
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerFeignApp80 {

    @Bean
    public IRule iRule() {

        return new RandomRule();
    }

    public static void main(String[] args) {

        SpringApplication.run(ConsumerFeignApp80.class, args);
    }
}
