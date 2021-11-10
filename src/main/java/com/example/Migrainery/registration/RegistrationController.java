package com.example.Migrainery.registration;
import com.example.Migrainery.user.User;
import com.example.Migrainery.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void register(@Valid @RequestBody() UserRegistration userRegistration) {
        userService.addNewUser(new User("test","test","test", userRegistration.getEmail(), userRegistration.getPassword()));
        System.out.println("Register" + userRegistration.getEmail() + " " + userRegistration.getPassword());
    }
}
