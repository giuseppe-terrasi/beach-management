package it.terrasi.beachmanagement.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import it.terrasi.beachmanagement.entities.User;
import it.terrasi.beachmanagement.models.UserModel;
import it.terrasi.beachmanagement.services.UserService;

@Controller
public class UserControler {
    
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        modelAndView.addObject("user", new UserModel());
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registrationPost(ModelAndView modelAndView, @Valid @ModelAttribute("user") UserModel userModel, BindingResult bindingResult) {
        User user = userService.findUserByUsername(userModel.getUsername());

        if(user != null) {
            bindingResult.rejectValue("username", "error.user", "There is already a user registered with the user name provided");
        }

        if(!bindingResult.hasErrors()) {
            user = new User();
            user.setUsername(userModel.getUsername());
            user.setPassword(userModel.getPassword());
            user.setFirstName(userModel.getFirstName());
            user.setLastName(userModel.getLastName());
            user.setActive(true);
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new UserModel());
        }

        modelAndView.setViewName("registration");

        return modelAndView;
    }
}