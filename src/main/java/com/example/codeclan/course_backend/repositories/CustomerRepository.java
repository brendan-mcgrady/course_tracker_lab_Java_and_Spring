package com.example.codeclan.course_backend.repositories;

import com.example.codeclan.course_backend.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseId(Long id);
    List<Customer> findByBookingsCourseIdAndTownIgnoreCase(Long id, String town);
    List<Customer> findByBookingsCourseIdAndTownIgnoreCaseAndAgeGreaterThan(Long id, String town, int age);

}
