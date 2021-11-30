package com.example.Migrainery.controllers;

import com.example.Migrainery.models.AttackModel;
import com.example.Migrainery.services.AttackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class AttackController {

    private final AttackService attackService;

    @Autowired
    public AttackController(AttackService attackService) {
        this.attackService = attackService;
    }

    @GetMapping("/attacks/{userId}")
    public AttackModel[] getAttacks(@PathVariable String userId) {
        return attackService.getAttacksForUserId(Long.parseLong(userId));
    }

    @PostMapping("/attacks")
    public AttackModel newAttack(@RequestBody AttackModel attack) {
        return attackService.saveAttack(attack);
    }

}
