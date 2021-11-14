package com.example.Migrainery.services;

import com.example.Migrainery.models.AttackModel;
import com.example.Migrainery.repository.AttackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttackService {


    final private AttackRepository attackRepository;

    @Autowired
    public AttackService(AttackRepository attackRepository) {
        this.attackRepository = attackRepository;
    }

    public List<AttackModel> getAttacks(){
        return attackRepository.findAll();
    }

}
