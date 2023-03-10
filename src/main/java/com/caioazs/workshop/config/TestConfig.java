package com.caioazs.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.caioazs.workshop.dto.AuthorDTO;
import com.caioazs.workshop.models.Post;
import com.caioazs.workshop.models.User;
import com.caioazs.workshop.repositories.PostRepository;
import com.caioazs.workshop.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        postRepository.deleteAll();
        userRepository.deleteAll();

        User jonas = new User(null, "jonas brothers", "jonas@gmail.com", "jonas_70correr");
        User caio = new User(null, "caio delas", "caio@gmail.com", "azscaio");
        User jorge = new User(null, "jorge", "jorge@gmail.com", "jorge_araga0");

        userRepository.saveAll(Arrays.asList(jonas, caio, jorge));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Pai ta on", "Bo jogar um lolzim", new AuthorDTO(jonas));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Nao acredito",
                "Quem foi q vazou foto do meu cheetos?????", new AuthorDTO(caio));

        postRepository.saveAll(Arrays.asList(post1, post2));

        jonas.getPosts().add(post1);
        caio.getPosts().add(post2);
        userRepository.saveAll(Arrays.asList(jonas, caio));
    }
}
