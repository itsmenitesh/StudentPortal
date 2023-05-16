package com.student.portal.service;

import com.student.portal.model.Course;
import com.student.portal.model.Student;
import com.student.portal.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    ICourseRepository iCourseRepository;

    public String addCourseData(List<Course> courses) {
        List<Course> courseList = iCourseRepository.saveAll(courses);
        if(courseList !=null){
            return "course added ";
        }else {
            return "wrong data";
        }
    }


    // R // allCourse
    public List<Course> allCourseData() {
        return iCourseRepository.findAll();
    }


    // U // UpdateCourseById

    public String updateCourseDataById(Long courseID, Course course) {
        Optional<Course> courseList = iCourseRepository.findById(courseID);
        if(courseList.isEmpty()){
            return "No Course is exists with this Id please check again";
        }else {
            course.setCourseID(courseID);
            iCourseRepository.save(course);
            return "data Updated";
        }
    }


    // D // deleteCourseById
    public String deleteCourseDataBYId(Long courseID) {
        Optional<Course> courseList = iCourseRepository.findById(courseID);
        if(courseList.isEmpty()){
            return "No Course is exists with this Id please check again";
        }else {

            iCourseRepository.deleteById(courseID);
            return "data deleted";
        }
    }
}
