package com.example.starship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.starship.entity")
public class StarshipApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarshipApplication.class, args);
    }

}