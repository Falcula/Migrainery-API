package com.example.Migrainery.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


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

    @Column(name="id",nullable = false)
    private Long id;

    @Column(name="level",nullable = false)
    private int level;

    @Column(name="timestamp",nullable = false)
    private Date timestamp;

}
 