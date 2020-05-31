package it.terrasi.beachmanagement.controllers;

import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import it.terrasi.beachmanagement.entities.UmbrellaGrid;
import it.terrasi.beachmanagement.services.UmbrellaGridSerivice;

@Controller
public class UmbrellaGridController {
    
    @Autowired
    private UmbrellaGridSerivice umbrellaGridSerivice;
    
    @GetMapping("/admin/grid")
    public ModelAndView grid(ModelAndView modelAndView) {
        
        Set<Entry<Integer, List<UmbrellaGrid>>> grid = umbrellaGridSerivice.getGrid();
        modelAndView.addObject("grid", grid);
        modelAndView.addObject("cssActivePage", "gird");
        modelAndView.setViewName("admin/umbrellaGrid");

        return modelAndView;
    }

    @PostMapping(value = "/admin/addUmbrella", consumes = "application/json")
    public ModelAndView addUmbrella(@RequestBody UmbrellaGrid model) {
        ModelAndView modelAndView = new ModelAndView("fragments/grid/gridTd");
        model = umbrellaGridSerivice.saveUmbrellaGrid(model);

        modelAndView.addObject("column", model);

        return modelAndView;
    }

}