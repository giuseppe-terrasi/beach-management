package it.terrasi.beachmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
    
    @GetMapping("/admin/dashboard")
    public ModelAndView dashboard(ModelAndView modelAndView) {
        modelAndView.addObject("cssActivePage", "dashboard");
        modelAndView.setViewName("admin/dashboard");
        return modelAndView;
    }
}
