package com.example.Migrainery.user;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor


@Entity
@Table(name = "Users")


public class User {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName="user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long Id;

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @Transient
    private String fullName;

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public User(String userName, String firstName, String lastName, String email, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
