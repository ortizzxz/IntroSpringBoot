/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;


/**
 *
 * @author Jesus
 */
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id; 
    private String name; 
    private String email;
    private LocalDate odb;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id, 
                   String name, 
                   String email, 
                   LocalDate odb) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.odb = odb;
    }

    public Student(String name, 
                   String email, 
                   LocalDate odb) {
        this.name = name;
        this.email = email;
        this.odb = odb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getOdb() {
        return odb;
    }

    public void setOdb(LocalDate odb) {
        this.odb = odb;
    }

    public Integer getAge() {
        return Period.between(this.odb, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", email=" + email + ", odb=" + odb + ", age=" + age + '}';
    }

    
    
}
