package com.example.demo.student.utils;

public class StudentUpdateDTO {
    private String name;
    public StudentUpdateDTO(String name){
        this.name = name;
    }
    public StudentUpdateDTO(){}

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
}
