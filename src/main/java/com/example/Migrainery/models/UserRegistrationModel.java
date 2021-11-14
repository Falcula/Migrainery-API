package com.example.Migrainery.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserRegistrationModel {
    @Email(message="Email is in wrong format")
    private String email;
    @NotBlank(message = "Password can not be empty")
    private String password;
    private String firstname;
    private String lastname;
}
