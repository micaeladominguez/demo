package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(String orderBY, String form){
        if(form != null && form.equals("DESC")  && orderBY != null){
            System.out.println("desc");
            return studentRepository.findAll(Sort.by(Sort.Direction.DESC, orderBY));
        }
        if(form != null && form.equals("ASC")  && orderBY != null){
            System.out.println("asc");
            return studentRepository.findAll(Sort.by(Sort.Direction.ASC, orderBY));
        }
      return studentRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public void addNewStudent(Student student) throws IllegalAccessException {
       Optional<Student> studentByEmail =  studentRepository.findStudentByEmail(student.getEmail());
       if( studentByEmail.isPresent()){
           throw new IllegalAccessException("email taken");
       }
        System.out.println(student);
       studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) throws IllegalAccessException {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalAccessException("student wiht id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Modifying
    public void updateStudent(Long studentId, String name) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exists"
                ));
        System.out.println(name);
        if(name != null && name.length() > 0){
            student.setName(name);
            studentRepository.save(student);
        }
    }
}
