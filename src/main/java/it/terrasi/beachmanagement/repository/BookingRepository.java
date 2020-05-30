package it.terrasi.beachmanagement.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.terrasi.beachmanagement.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    public List<Booking> findByUserId(long userId, Sort sort);

    public List<Booking> findByFromDateAndToDate(Date fromDate, Date toDate, Sort sort);

    public Booking findByFromDateAndToDateAndUmbrellas_id(Date fromDate, Date toDate, int umbrellaId);
}