package com.example.demo.student;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student  {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String name;
    @Transient
    private Integer age;
    private LocalDate dov;
    private String email;

    public Student(){}

    public Student(String id,
                   String name,
                   LocalDate dov,
                   String email) {
        this.id = id;
        this.name = name;
        this.dov = dov;
        this.email = email;
    }

    public Student(String name,
                   LocalDate dov,
                   String email) {
        this.name = name;
        this.dov = dov;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return Period.between(this.dov, LocalDate.now()).getYears();
    }

    public LocalDate getDov() {
        return dov;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDov(LocalDate dov) {
        this.dov = dov;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dov=" + dov +
                ", email='" + email + '\'' +
                '}';
    }


}
