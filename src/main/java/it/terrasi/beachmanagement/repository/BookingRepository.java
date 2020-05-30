package it.terrasi.beachmanagement.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.terrasi.beachmanagement.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    
    public Set<Booking> findByUserId(long userId, Sort sort);

    public Set<Booking> findByFromDateAndToDate(Date fromDate, Date toDate, Sort sort);

    public Booking findByFromDateAndToDateAndUmbrellas_id(Date fromDate, Date toDate, int umbrellaId);
}