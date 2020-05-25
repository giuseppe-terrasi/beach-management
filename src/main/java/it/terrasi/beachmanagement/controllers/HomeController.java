package it.terrasi.beachmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        modelAndView.addObject("name", "pluto");
        return modelAndView;
    }
}