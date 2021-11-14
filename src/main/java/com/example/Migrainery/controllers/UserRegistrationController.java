package com.example.Migrainery.controllers;
import com.example.Migrainery.models.UserRegistrationModel;
import com.example.Migrainery.models.UserModel;
import com.example.Migrainery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class UserRegistrationController {

    @Autowired
    final private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@Valid @RequestBody() UserRegistrationModel userRegistrationModel) {
        try {
            UserModel userModel = new UserModel(userRegistrationModel.getFirstname(), userRegistrationModel.getLastname(), userRegistrationModel.getEmail(), userRegistrationModel.getPassword());
            userService.addNewUser(userModel);
            return new ResponseEntity<>(userModel, HttpStatus.OK);
        }
        catch(IllegalStateException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }
}
