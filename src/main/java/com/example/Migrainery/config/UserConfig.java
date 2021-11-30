package com.example.Migrainery.config;

import com.example.Migrainery.models.AttackModel;
import com.example.Migrainery.models.UserModel;
import com.example.Migrainery.repository.AttackRepository;
import com.example.Migrainery.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, AttackRepository attackRepository) {
        return args -> {
          final List<UserModel> mockList =  List.of(
                    new UserModel("Jesper","Kramming","jesper.kramming@outlook.com","test"),
                    new UserModel("Jonas","Hannes","jonas.hannes@tony.com","test")
            );

            userRepository.saveAll(mockList);


           final List<AttackModel> attackList =  List.of(
                   new AttackModel(1L,4,new Date(), mockList.get(0)),
                   new AttackModel(2L,8,new Date(),mockList.get(1)),
                   new AttackModel(3L,4,new Date(),mockList.get(1)),
                   new AttackModel(4L,2,new Date(),mockList.get(1))
           );
           attackRepository.saveAll(attackList);

        };
    }

}
