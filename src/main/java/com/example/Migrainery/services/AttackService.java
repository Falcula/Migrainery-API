package com.example.Migrainery.services;

import com.example.Migrainery.models.AttackModel;
import com.example.Migrainery.repository.AttackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttackService {


    final private AttackRepository attackRepository;

    @Autowired
    public AttackService(AttackRepository attackRepository) {
        this.attackRepository = attackRepository;
    }

    public AttackModel[] getAttacksForUserId(Long userId){
        return attackRepository.findAttacksByUserId(userId);
    }

    public AttackModel saveAttack(AttackModel attackModel) {
        return attackRepository.save(attackModel);
    }

}
