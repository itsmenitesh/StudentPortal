package com.student.portal.controller;

import com.student.portal.model.Book;
import com.student.portal.model.Course;
import com.student.portal.model.Student;
import com.student.portal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    // C // addCourse
    @PostMapping()
    public String addCourse(@RequestBody List<Course> courses){

        return courseService.addCourseData(courses);
    }

    // R // allCourse
    @GetMapping()
    public List<Course> allCourse(){
        return courseService.allCourseData();
    }

    // U // UpdateCourseById
    @PutMapping("{courseID}")
    public String UpdateCourseById(@PathVariable Long courseID , @RequestBody Course course){
        return courseService.updateCourseDataById(courseID , course);
    }

    // D // deleteCourseById
    @DeleteMapping("{courseID}")
    public String deleteCourseById(@PathVariable Long courseID){
        return courseService.deleteCourseDataBYId(courseID);
    }
}
