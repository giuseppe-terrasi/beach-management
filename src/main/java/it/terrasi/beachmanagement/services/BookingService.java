package it.terrasi.beachmanagement.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.terrasi.beachmanagement.entities.Booking;
import it.terrasi.beachmanagement.repository.BookingRepository;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getBookings(Date fromDate, Date toDate) {
        return bookingRepository.findByFromDateAndToDate(fromDate, toDate, Sort.by(Sort.Direction.ASC, "fromDate"));
    }

    public List<Booking> getUserBookings(long userId) {
        return bookingRepository.findByUserId(userId, Sort.by(Sort.Direction.ASC, "fromDate"));
    }

    public boolean isUmbrellaBooked(Date fromDate, Date toDate, int umbrellaId) {
        Booking booking = bookingRepository.findByFromDateAndToDateAndUmbrellas_id(fromDate, toDate, umbrellaId);

        return booking != null;
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
}