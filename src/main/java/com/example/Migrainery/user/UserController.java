package com.example.Migrainery.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path="api/v1/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(path="api/v1/user")
    public void newUser(@RequestBody User user){
        userService.addNewUser(user);
    }
}
