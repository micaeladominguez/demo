package com.example.demo.student;

import com.example.demo.student.utils.StudentUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<Student> getStudents(@RequestParam(required = false) String orderBy, @RequestParam(required = false) String form){
       return studentService.getStudents(orderBy, form);
    }

    @RequestMapping( method = RequestMethod.POST)
    public void registerNewStudent(@RequestBody Student student) throws IllegalAccessException {
        studentService.addNewStudent(student);
    }

    @RequestMapping( method = RequestMethod.DELETE, path = "{studentId}" )
    public void deleteStudent(@PathVariable("studentId") Long studentId) throws IllegalAccessException {
        studentService.deleteStudent(studentId);
    }

    @RequestMapping( method = RequestMethod.PUT, path = "{studentId}" )
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestBody(required = false) StudentUpdateDTO studentUpdateDTO) throws IllegalAccessException {
        studentService.updateStudent(studentId, studentUpdateDTO.getName());
    }

}
