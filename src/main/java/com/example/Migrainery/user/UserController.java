package com.example.Migrainery.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(path="api/user", method = RequestMethod.GET)
    public User getUser(){
        return new User(1L,"Falcula","Jesper", "Kramming","jesper.kramming@outlook.com");

    }
}
