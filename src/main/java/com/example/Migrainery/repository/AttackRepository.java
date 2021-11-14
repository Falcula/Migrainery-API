package com.example.Migrainery.repository;

import com.example.Migrainery.models.AttackModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttackRepository extends JpaRepository<AttackModel,Long> {
}
