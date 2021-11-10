package com.example.Migrainery.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
          final List<User> mockList =  List.of(
                    new User("Falcula","Jesper","Kramming","jesper.kramming@outlook.com","test"),
                    new User("Griftenatt","Jonas","Hannes","jonas.hannes@tony.com","test")
            );
            userRepository.saveAll(mockList);
        };
    }

}
