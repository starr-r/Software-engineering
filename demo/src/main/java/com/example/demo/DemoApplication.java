package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {
    //netstat -ano|findstr “8080”
    //taskkill /F /pid
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
