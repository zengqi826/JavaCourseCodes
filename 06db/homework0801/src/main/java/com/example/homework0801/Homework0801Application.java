package com.example.homework0801;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;

@MapperScan("com.example.homework0801.repository")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)

public class Homework0801Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework0801Application.class, args);
    }

}
