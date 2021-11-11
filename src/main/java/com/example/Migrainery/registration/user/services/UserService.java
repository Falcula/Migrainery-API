package com.example.Migrainery.registration.user.services;

import com.example.Migrainery.registration.user.models.User;
import com.example.Migrainery.registration.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public void addNewUser(User user){

       Optional<User> userOptional = userRepository.
               findUserByEmail(user.getEmail());
       if(userOptional.isPresent()) {
           throw new IllegalStateException("Email taken");
       }
       else {
           userRepository.save(user);
       }
    }
    public Optional<User> getUserByEmail(String email) {
          return userRepository.findUserByEmail(email);
    }

    public void deleteUser(Long id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        else {
            throw new IllegalStateException("User with id" + id + "does not exist");
        }
    }



}