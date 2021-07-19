package com.example.homeworkweek05;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Homeworkweek05Application {

    public static void main(String[] args) {
        getBeanByXml();
        getBeanByAnnotation();
        // SpringApplication.run(Homeworkweek05Application.class, args);
    }

    private static void getBeanByXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student123 = (Student) context.getBean("student123");
        System.out.println(student123.toString());
    }

    private static void getBeanByAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.homeworkweek05");
        Student student456 = (Student) context.getBean("student456");
        System.err.println(student456.toString());
    }

}
