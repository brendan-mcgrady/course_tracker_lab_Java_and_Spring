package com.example.codeclan.course_backend.controllers;

import com.example.codeclan.course_backend.models.Customer;
import com.example.codeclan.course_backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    ResponseEntity<List<Customer>> findCustomerByCourseOrTownOrAge(
            @RequestParam(name = "course_id") Long id,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "age") Integer age
    )
    {
        if (age == null) {
            if (town == null) {
                List<Customer> foundCustomers = customerRepository.findByBookingsCourseId(id);
                return new ResponseEntity<List<Customer>>(foundCustomers, HttpStatus.OK);
            }
            List<Customer> foundCustomers = customerRepository.findByBookingsCourseIdAndTownIgnoreCase(id, town);
            return new ResponseEntity<List<Customer>>(foundCustomers, HttpStatus.OK);
        }
//        if (age == null && town == null) {
//            List<Customer> foundCustomers = customerRepository.findByBookingsCourseId(id);
//            return new ResponseEntity<List<Customer>>(foundCustomers, HttpStatus.OK);
//        }

            List<Customer> foundCustomers = customerRepository.findByBookingsCourseIdAndTownIgnoreCaseAndAgeGreaterThan(id, town, age);
            return new ResponseEntity<List<Customer>>(foundCustomers, HttpStatus.OK);
    }


    //    ResponseEntity<List<Customer>> findCustomerByCourse(
    //            @RequestParam(name = "course_id") Long id) {
    //        List<Customer> foundCustomers = customerRepository.findByBookingsCourseId(id);
    //        return new ResponseEntity<List<Customer>> (foundCustomers, HttpStatus.OK);

}
