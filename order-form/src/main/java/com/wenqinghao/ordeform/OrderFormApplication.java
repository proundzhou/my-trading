package com.wenqinghao.ordeform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.wenqinghao.ordeform.mapper")
public class OrderFormApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderFormApplication.class, args);
    }

}
