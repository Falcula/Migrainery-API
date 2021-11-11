package com.example.Migrainery.registration.controllers;
import com.example.Migrainery.registration.models.UserRegistration;
import com.example.Migrainery.registration.user.models.User;
import com.example.Migrainery.registration.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class RegistrationController {

    @Autowired
    final private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody() UserRegistration userRegistration) {
        try {
            User user = new User(userRegistration.getFirstname(), userRegistration.getLastname(), userRegistration.getEmail(), userRegistration.getPassword());
            userService.addNewUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch(IllegalStateException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }
}
