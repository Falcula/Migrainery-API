package com.example.Migrainery.services;

import com.example.Migrainery.models.UserModel;
import com.example.Migrainery.repository.UserRepository;
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

    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }

    public Optional<UserModel> getUser(Long id) {
        return userRepository.findById(id);
    }

    public void addNewUser(UserModel userModel){

       Optional<UserModel> userOptional = userRepository.
               findUserByEmail(userModel.getEmail());
       if(userOptional.isPresent()) {
           throw new IllegalStateException("Email taken");
       }
       else {
           userRepository.save(userModel);
       }
    }
    public Optional<UserModel> getUserByEmail(String email) {
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
