/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        
        // si existe lanzamos exception
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Este email ya existe.");
        }
        
        //si no agregamos
        studentRepository.save(student);
    }

    void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        
        if(!exists){
            throw new IllegalStateException("ID no está asociado a ningún "
                    + "estudiante");
        }
        
        //SI EXISTE LO BORRAMOS 
        studentRepository.deleteById(studentId);
    }

        // EDITAR ESTUDIANTE
    @Transactional
    void updateStudent(Long studentId, 
                       String name, 
                       String email) {
        Student student = studentRepository.findById(studentId).    //AQUI ESTAMOS HACIENDO UNA 
                          orElseThrow(() -> new IllegalStateException( // BUSQUEDA POR ID Y SI NO EXISTE
                          "ID no asociado a ningún estudiante."));   // LANZAMOS UNA EXCEPCION
        
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        
        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        
            // si existe lanzamos exception
            if(studentByEmail.isPresent()){
                throw new IllegalStateException("Este email ya existe.");
            }

            //si no agregamos
            student.setEmail(email);
        }
        
    }
}
