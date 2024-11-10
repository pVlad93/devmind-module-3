package edu.devmind.spring_boot.controller;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HarryPotterController {

    private final Faker faker = new Faker();

    @GetMapping("/harry-potter")
    public String harryPotter() {
        return faker.harryPotter().character();
    }

}
