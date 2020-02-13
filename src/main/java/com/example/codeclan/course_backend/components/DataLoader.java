package com.example.codeclan.course_backend.components;

import com.example.codeclan.course_backend.models.Booking;
import com.example.codeclan.course_backend.models.Course;
import com.example.codeclan.course_backend.models.Customer;
import com.example.codeclan.course_backend.repositories.BookingRepository;
import com.example.codeclan.course_backend.repositories.CourseRepository;
import com.example.codeclan.course_backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Customer customer1 = new Customer("Mark", "Glasgow", 21);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Brendan", "Airdrie", 40);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Mary", "Glasgow", 18);
        customerRepository.save(customer3);

        Customer customer4 = new Customer("Ally Bally Bee", "Glasgow", 30);
        customerRepository.save(customer4);

        Course course1 = new Course("Intro To Python", "Glasgow", 4);
        courseRepository.save(course1);

        Course course2 = new Course("Intro To Java", "Edinburgh", 3);
        courseRepository.save(course2);

        Course course3 = new Course("Data Analysis", "Edinburgh", 5);
        courseRepository.save(course3);

        Course course4 = new Course("Intro To Python", "Edinburgh", 2);
        courseRepository.save(course4);

        Booking booking1 = new Booking("6/4/20", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("19/1/20", course2, customer3);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("1/1/20", course1, customer2);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("1/1/20", course3, customer1);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("1/1/20", course1, customer4);
        bookingRepository.save(booking5);

    }
}
