package com.example.Migrainery.repository;
import com.example.Migrainery.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {

    @Query("SELECT u from UserModel u WHERE u.email = ?1")
    Optional<UserModel> findUserByEmail(String email);

    @Query("SELECT u from UserModel u WHERE u.Id = ?1")
    Optional<UserModel> findUserById(Long id);


}
