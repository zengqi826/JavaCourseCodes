package com.example.homework0502;

import io.kimmking.spring01.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Klass { 
    List<Student> students;
}
