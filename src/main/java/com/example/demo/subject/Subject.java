package com.example.demo.subject;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Subject {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String name;

    public Subject(){}

    public Subject(
            String id,
            String name
    ){
        this.id = id;
        this.name= name;
    }
    public Subject(String name){
        this.name= name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
