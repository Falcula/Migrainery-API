package com.example.Migrainery.migrane.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class RegisterAttackController {

    @GetMapping("/attacks")
    public String getAttacks(Long id) {
        return "{attacks:[{}]}";
    }
}
