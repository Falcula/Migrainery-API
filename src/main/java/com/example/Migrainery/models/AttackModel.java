package com.example.Migrainery.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="AttackModel")
@Table(name = "Attacks")
public class AttackModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long Id;

    @Column(name="level",nullable = false)
    private int level;

    @Column(name="timestamp",nullable = false)
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserModel user;

}
 