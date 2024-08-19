package com.example.starship.service;

import com.example.starship.entity.User;
import com.example.starship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;


    public boolean register(String firstname, String lastname, String email, String password) {
        try {
            User User = new User(firstname, lastname, email, password);
            userRepository.save(User);
            return true;
        } catch (Exception e) {
            // Log the exception instead of printing
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(String email, String password) {
        try {
            User user = userRepository.findByEmail(email);
            return user != null && user.getPassword().equals(password);
        } catch (Exception e) {
            // Log the exception instead of printing
            e.printStackTrace();
            return false;
        }
    }
}
