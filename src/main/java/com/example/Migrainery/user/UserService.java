package com.example.Migrainery.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser(){
        return new User(1L,"Falcula","Jesper", "Kramming","jesper.kramming@outlook.com");
    }

}
