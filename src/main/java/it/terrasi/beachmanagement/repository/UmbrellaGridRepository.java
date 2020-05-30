package it.terrasi.beachmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.terrasi.beachmanagement.entities.UmbrellaGrid;

@Repository
public interface UmbrellaGridRepository extends JpaRepository<UmbrellaGrid, Integer> {
    
}