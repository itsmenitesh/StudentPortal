package com.student.portal.controller;

import com.student.portal.model.Student;
import com.student.portal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {
    @Autowired
    StudentService studentService;

    // C //addStudent
    @PostMapping()
    public String addStudent(@RequestBody Student student){

        return studentService.addStudentData(student);
    }
    // R // allStudent
    @GetMapping()
    public List<Student> allStudent(){
        return studentService.allStudentData();
    }


    // U // UpdateStudentById
    @PutMapping("{studentID}")
    public String updateStudentById(@PathVariable Long studentID , @RequestBody Student student){
        return studentService.updateStudentDataById(studentID , student);
    }

    // D // deleteStudentById
    @DeleteMapping("{studentID}")
    public String deleteStudentById(@PathVariable Long studentID){
        return studentService.deleteStudentDataBYId(studentID);
    }
}
