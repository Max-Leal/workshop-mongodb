package com.max.workshopmongodb.config;

import com.max.workshopmongodb.domain.Post;
import com.max.workshopmongodb.domain.User;
import com.max.workshopmongodb.dto.AuthorDTO;
import com.max.workshopmongodb.repository.PostRepository;
import com.max.workshopmongodb.repository.UserRepository;
import com.max.workshopmongodb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instanciation implements CommandLineRunner {

    @Autowired
    private UserRepository uRepository;
    @Autowired
    private PostRepository pRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        uRepository.deleteAll();
        pRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        uRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null,sdf.parse("21/03/2018") , "Partiu Viagem!", "Vou viajar para São Paulo, Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!","Acordei feliz hoje!", new AuthorDTO(maria));


        pRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        uRepository.save(maria);
    }
}
