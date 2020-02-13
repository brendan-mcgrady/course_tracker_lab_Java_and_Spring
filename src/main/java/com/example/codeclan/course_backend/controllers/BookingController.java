package com.example.codeclan.course_backend.controllers;

import com.example.codeclan.course_backend.models.Booking;
import com.example.codeclan.course_backend.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    ResponseEntity<List<Booking>> findBookingsByDate(
            @RequestParam(name = "date") String date) {
        List<Booking> found = bookingRepository.findByDate(date);
        return new ResponseEntity<List<Booking>>(found, HttpStatus.OK);
    }

}
