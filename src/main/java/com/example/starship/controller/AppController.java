package com.example.starship.controller;

import com.example.starship.service.RegistrationService;
import com.example.starship.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AppController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/")
    public String home() {
        return "home.html"; // Ensure you have a home.html file in your templates
    }

    //If in case things fail (i am using this as a fallback)
    @GetMapping ("/error")
    public String error() {
        return ("error.html");
    }

    //To auth the user
    @PostMapping("/loginauth")
    public String loginauth(@RequestBody UserDTO userDTO) {
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();
        if (registrationService.login(email, password)) {
            return "redirect:feed.html?email=" + email; // Assuming feed is a valid route
        } else {
            return "redirect:login.html?message=Please check your email and password.";
        }
    }

    //to create a new user
    @PostMapping("/registerauth")
    public String register(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.getFirstname());
        if (registrationService.login(userDTO.getEmail(), userDTO.getPassword())) {
            return "redirect:/register.html?message=Email Exist!"; // Ensure you have a feed route or page
        } else {
            registrationService.register(userDTO.getFirstname(), userDTO.getLastname(), userDTO.getEmail(), userDTO.getPassword());
            System.out.println(userDTO.getFirstname());
            System.out.println(userDTO.getLastname());
            System.out.println(userDTO.getEmail());
            System.out.println(userDTO.getPassword());// Ensure you have a login route or page
            return "redirect:/login.html?message=Account created Successfully!";
        }
    }
}