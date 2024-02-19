/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
        
        private final StudentService studentService;
        
        @GetMapping
        public List<Student> getStudents(){
            return studentService.getStudents();
        }
        
        @PostMapping
        public void RegisterNewStudent(@RequestBody Student student){
            studentService.addNewStudent(student);
        }
    
}
