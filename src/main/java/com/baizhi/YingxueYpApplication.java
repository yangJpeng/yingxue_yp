package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@tk.mybatis.spring.annotation.MapperScan("com.baizhi.dao")
@org.mybatis.spring.annotation.MapperScan("com.baihi.dao")
@SpringBootApplication
public class YingxueYpApplication {

    public static void main(String[] args) {
        SpringApplication.run(YingxueYpApplication.class, args);
    }

}
