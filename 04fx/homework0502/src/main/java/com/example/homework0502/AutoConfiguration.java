package com.example.homework0502;

import io.kimmking.spring01.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * AutoConfiguration
 *
 * @author zengqi
 * @date 2021/7/19 16:37
 */

@Configuration
@EnableConfigurationProperties(StudentProperties.class)
public class AutoConfiguration {
    @Resource
    private StudentProperties studentProperties;
    @Bean
    @ConditionalOnMissingBean
    public Student student() {
        return new Student(studentProperties.getId(),studentProperties.getName());
    }

    @Bean
    @ConditionalOnMissingBean
    public Klass klass() {
        return new Klass();
    }

    @Bean
    @ConditionalOnMissingBean
    public School school() {
        return new School();
    }
}
