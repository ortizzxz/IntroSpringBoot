/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jesus
 */

@Service
public class StudentService {

    
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(com.example.demo.student.StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    
    public List<Student> getStudents(){
            return studentRepository.findAll();
        }

    void addNewStudent(Student student) {
        System.out.println(student);
    }
}
