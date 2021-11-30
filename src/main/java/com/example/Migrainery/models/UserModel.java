package com.example.Migrainery.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity(name="UserModel")
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(name="user_email_unique", columnNames = "email")
})
public class UserModel {

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

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name",nullable = false)
    private String lastName;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name="password",nullable = false)
    @JsonIgnore
    private String password;


    @Transient
    private String fullName;

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public UserModel(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
