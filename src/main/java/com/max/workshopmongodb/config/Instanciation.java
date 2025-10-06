package com.max.workshopmongodb.config;

import com.max.workshopmongodb.domain.User;
import com.max.workshopmongodb.repository.UserRepository;
import com.max.workshopmongodb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instanciation implements CommandLineRunner {

    @Autowired
    private UserRepository repo;

    @Override
    public void run(String... args) throws Exception {

        repo.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        repo.save(maria);
        repo.save(alex);
        repo.save(bob);
    }
}
