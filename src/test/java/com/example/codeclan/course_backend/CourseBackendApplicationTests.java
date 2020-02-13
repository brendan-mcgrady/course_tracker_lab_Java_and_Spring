package com.example.codeclan.course_backend;

import com.example.codeclan.course_backend.models.Booking;
import com.example.codeclan.course_backend.models.Course;
import com.example.codeclan.course_backend.models.Customer;
import com.example.codeclan.course_backend.repositories.BookingRepository;
import com.example.codeclan.course_backend.repositories.CourseRepository;
import com.example.codeclan.course_backend.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBackendApplicationTests {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canGetCourseByRating() {
		List<Course> found = courseRepository.findByRating(5);
		assertEquals(1, found.size());
	}

	@Test
	void canGetCustomerForGivenCourse() {
		List<Customer> found = customerRepository.findByBookingsCourseId(1L);
		assertEquals(3, found.size());
		assertEquals("Mark", found.get(0).getName());
		assertEquals("Brendan", found.get(1).getName());
		assertEquals("Ally Bally Bee", found.get(2).getName());
	}

	@Test
	void canGetCourseForGivenCustomer() {
		List<Course> found = courseRepository.findByBookingsCustomerId(1L);
		assertEquals(2, found.size());
		assertEquals("Intro To Python", found.get(0).getName());
		assertEquals("Data Analysis", found.get(1).getName());
	}

	@Test
	void canGetBookingsForGivenDate() {
		List<Booking> found = bookingRepository.findByDate("1/1/20");
		assertEquals(3, found.size());
	}

	@Test
	void canGetCustomerForGivenTownForGivenCourse() {
		List<Customer> found = customerRepository.findByBookingsCourseIdAndTownIgnoreCase(1L, "GlASgow");
		assertEquals(2, found.size());
		assertEquals("Mark", found.get(0).getName());
		assertEquals("Ally Bally Bee", found.get(1).getName());
	}

	@Test
	void canGetCustomerForGivenTownForGivenCourseOverGivenAge() {
		List<Customer> found = customerRepository.findByBookingsCourseIdAndTownIgnoreCaseAndAgeGreaterThan(1L, "GLasgow", 22);
		assertEquals(1, found.size());
		assertEquals("Ally Bally Bee", found.get(0).getName());
	}

}
