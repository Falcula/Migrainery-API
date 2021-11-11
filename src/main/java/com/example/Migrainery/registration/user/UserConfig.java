package com.example.Migrainery.registration.user;

import com.example.Migrainery.registration.user.models.User;
import com.example.Migrainery.registration.user.repository.UserRepository;
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
                    new User("Jesper","Kramming","jesper.kramming@outlook.com","test"),
                    new User("Jonas","Hannes","jonas.hannes@tony.com","test")
            );
            userRepository.saveAll(mockList);
        };
    }

}
