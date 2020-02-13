package com.example.codeclan.course_backend.controllers;

import com.example.codeclan.course_backend.models.Course;
import com.example.codeclan.course_backend.models.Customer;
import com.example.codeclan.course_backend.repositories.CourseRepository;
import com.example.codeclan.course_backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    ResponseEntity<List<Course>> findCourseByCustomerIdOrRating(
            @RequestParam(required = false, name = "customer_id") Long id,
            @RequestParam(required = false, name = "rating") Integer rating
    )
    {
        if (id != null) {
            List<Course> foundCourses = courseRepository.findByBookingsCustomerId(id);
            return new ResponseEntity<List<Course>> (foundCourses, HttpStatus.OK);
        }
        if (rating != null) {
            List<Course> foundCourses = courseRepository.findByRating(rating);
            return new ResponseEntity<List<Course>> (foundCourses, HttpStatus.OK);
        }
        return new ResponseEntity<List<Course>>(courseRepository.findAll(), HttpStatus.OK);
    }

}


