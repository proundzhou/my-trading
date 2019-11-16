package com.wqh.project.picturecenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wqh.project.picturecenter.mapper")
public class PictureCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PictureCenterApplication.class, args);
    }

}
