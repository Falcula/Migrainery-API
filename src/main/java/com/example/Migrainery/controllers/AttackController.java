package com.example.Migrainery.controllers;

import com.example.Migrainery.models.AttackModel;
import com.example.Migrainery.services.AttackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AttackController {

    private final AttackService attackService;

    @Autowired
    public AttackController(AttackService attackService) {
        this.attackService = attackService;
    }

    @GetMapping("/attacks")
    public List<AttackModel> getAttacks() {
        return attackService.getAttacks();
    }
}
