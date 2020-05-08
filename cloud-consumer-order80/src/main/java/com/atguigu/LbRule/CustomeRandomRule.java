package com.atguigu.LbRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 对特定服务定制负载均衡策略，放在ComponentScan的范围外。
 *
 * @author: Justin
 */
@Configuration
public class CustomeRandomRule {

    @Bean
    public IRule random() {

        return new RandomRule();
    }
}
