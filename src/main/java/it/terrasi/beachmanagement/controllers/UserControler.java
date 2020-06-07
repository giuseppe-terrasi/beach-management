package it.terrasi.beachmanagement.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.terrasi.beachmanagement.entities.User;
import it.terrasi.beachmanagement.models.AppUser;
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
            userService.createUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new UserModel());
        }

        modelAndView.setViewName("registration");

        return modelAndView;
    }

    @GetMapping("/profile")
    public ModelAndView userProfile(ModelAndView modelAndView)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        AppUser appUser = (AppUser)auth.getPrincipal();

        UserModel userModel = new UserModel(appUser);

        modelAndView.setViewName("user/profile");
        modelAndView.addObject("user", userModel);
        return modelAndView;
    }

    @PostMapping("/profile")
    public ModelAndView updateProfileInfo(ModelAndView modelAndView, @Valid @ModelAttribute("user") UserModel userModel, BindingResult bindingResult,
        RedirectAttributes redirectAttributes)
    {
        if(userModel.getPassword().length() == 0 && userModel.getConfirmPassword().length() == 0)
        {
            List<FieldError> errors = bindingResult.getFieldErrors().stream().filter(e -> (!e.getField().equals("password") && !e.getField().equals("confirmPassword")))
            .collect(Collectors.toList());

            bindingResult = new BeanPropertyBindingResult(userModel, "user");

            for(FieldError error : errors){
                bindingResult.addError(error);
            }
        }

        if(!bindingResult.hasErrors()) {
            User user = userService.findUserByUsername(userModel.getUsername());

            user.setUsername(userModel.getUsername());
            if(userModel.getConfirmPassword().length() > 0) user.setPassword(userModel.getPassword());
            user.setFirstName(userModel.getFirstName());
            user.setLastName(userModel.getLastName());
            userService.saveUser(user);

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            AppUser principal = (AppUser)auth.getPrincipal();
            principal.setFirstName(userModel.getFirstName());
            principal.setLastName(userModel.getLastName());

            Authentication newAuth = new UsernamePasswordAuthenticationToken(principal, auth.getCredentials(), auth.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(newAuth);
            redirectAttributes.addAttribute("success", true);
            modelAndView.setViewName("redirect:/profile");
        }
        else {
            modelAndView.setViewName("user/profile");
        }
        return modelAndView;
    }

    @GetMapping("/admin/users")
    public ModelAndView users(ModelAndView modelAndView)
    {
        modelAndView.setViewName("/admin/manageUsers");
        modelAndView.addObject("cssActivePage", "manageUsers");

        List<User> users = userService.getAll();
        
        modelAndView.addObject("users", users);

        return modelAndView;
    }
}