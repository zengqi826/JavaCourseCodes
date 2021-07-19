package com.example.homeworkweek05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * StudentConfiguration
 *
 * @author zengqi
 * @date 2021/7/19 15:34
 */

@Configuration
public class StudentConfiguration {

    @Bean
    public Student student456() {
        return new Student(456, "zengqi456");
    }
}
