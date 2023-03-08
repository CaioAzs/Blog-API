package com.caioazs.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.caioazs.workshop.models.User;
import com.caioazs.workshop.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User jonas = new User(null, "jonas brothers", "jonas@gmail.com", "jonas_70correr");
        User caio = new User(null, "caio delas", "caio@gmail.com", "azscaio");
        User  jorge= new User(null, "jorge", "jorge@gmail.com", "jorge_araga0");

        userRepository.saveAll(Arrays.asList(jonas, caio, jorge));
    }

}
