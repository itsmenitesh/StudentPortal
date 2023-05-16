package com.student.portal.service;

import com.student.portal.model.Student;
import com.student.portal.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepository iStudentRepository;

    // C //addStudent
    public String addStudentData(Student student) {
        if(student!=null){
            iStudentRepository.save(student);
            return "student added";
        }
        return "something went wrong";

    }

    // R // AllStudent
    public List<Student> allStudentData() {
        return iStudentRepository.findAll();
    }


    // U // UpdateStudentById
    public String updateStudentDataById(Long studentID, Student student) {
        Optional<Student> studentList = iStudentRepository.findById(studentID);
        if(studentList.isEmpty()){
            return "No Student is exists with this Id please check again";
        }else {
            student.setStudentID(studentID);
            iStudentRepository.save(student);
            return "data Updated";
        }

    }


    // D // deleteStudentById
    public String deleteStudentDataBYId(Long studentID) {
        Optional<Student> optionalStudent = iStudentRepository.findById(studentID);
        if (optionalStudent.isEmpty()){
            return "No Student is exists with this Id please check again";
        }else {
            iStudentRepository.deleteById(studentID);
            return "student data with this id has been deleted";
        }
    }
}
