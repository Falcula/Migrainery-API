package com.example.Migrainery.repository;

import com.example.Migrainery.models.AttackModel;
import com.example.Migrainery.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttackRepository extends JpaRepository<AttackModel,Long> {

    @Query("SELECT u from AttackModel u WHERE u.user.Id = ?1")
    AttackModel[] findAttacksByUserId(Long id);
}
