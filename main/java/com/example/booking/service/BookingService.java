package com.example.booking.service;

import com.example.booking.model.Booking;
import com.example.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;

    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    public void saveBooking(Booking booking) {
        repository.save(booking);
    }

    public Booking getBookingById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteBooking(Long id) {
        repository.deleteById(id);
    }
}
