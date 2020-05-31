package it.terrasi.beachmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UmbrellaGridController {
    
    @GetMapping("/admin/grid")
    public ModelAndView grid(ModelAndView modelAndView) {
        modelAndView.addObject("cssActivePage", "gird");
        modelAndView.setViewName("admin/umbrellaGrid");

        return modelAndView;
    }
}