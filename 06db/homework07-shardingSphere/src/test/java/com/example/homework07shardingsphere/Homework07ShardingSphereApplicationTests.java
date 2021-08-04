package com.example.homework07shardingsphere;

import com.example.homework07shardingsphere.model.Student;
import com.example.homework07shardingsphere.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class Homework07ShardingSphereApplicationTests {
    @Autowired
    StudentRepository studentRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void writeTest() {
        Student student = new Student(1,"zq");
        Student studentResult = studentRepository.save(student);
        System.out.println("插入数据：" + studentResult);
    }
    @Test
    void selectTest() {
        Optional<Student> Student1 = studentRepository.findById(1);
        System.out.println("查询数据：" + Student1.get());
        Optional<Student> Student2 = studentRepository.findById(1);
        System.out.println("查询数据：" + Student2.get());
    }

}
