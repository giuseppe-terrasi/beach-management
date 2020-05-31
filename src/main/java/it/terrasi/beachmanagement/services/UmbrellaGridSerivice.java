package it.terrasi.beachmanagement.services;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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

    public Set<Entry<Integer, List<UmbrellaGrid>>> getGrid() {
        Collection<UmbrellaGrid> grid = umbrellaGridRepository.findAll(Sort.by(Sort.Order.asc("gridRow"), Sort.Order.asc("gridColumn"))); 

        return grid.stream().collect(Collectors.groupingBy(g -> g.getGridRow())).entrySet();
    }
}