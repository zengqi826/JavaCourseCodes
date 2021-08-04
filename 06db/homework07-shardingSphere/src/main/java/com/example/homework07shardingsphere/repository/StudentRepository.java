package com.example.homework07shardingsphere.repository;

import com.example.homework07shardingsphere.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * repository
 *
 * @author zengqi
 * @date 2021/8/3 16:55
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
