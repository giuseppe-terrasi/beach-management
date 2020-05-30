package it.terrasi.beachmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.terrasi.beachmanagement.entities.UmbrellaGrid;
import it.terrasi.beachmanagement.repository.UmbrellaGridRepository;

@Service
public class UmbrellaGridSerivice {
    
    @Autowired
    private UmbrellaGridRepository umbrellaGridRepository;

    public UmbrellaGrid saveUmbrellaGrid(UmbrellaGrid umbrellaGrid) {
        return umbrellaGridRepository.save(umbrellaGrid);
    }

    public List<UmbrellaGrid> getGrid() {
        return umbrellaGridRepository.findAll(Sort.by(Sort.Order.asc("gridRow"), Sort.Order.asc("gridColumn")));
    }
}