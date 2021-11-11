package com.example.Migrainery.registration.user.repository;
import com.example.Migrainery.registration.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u from User u WHERE u.email = ?1")
    Optional<User> findUserByEmail(String email);

    @Query("SELECT u from User u WHERE u.Id = ?1")
    Optional<User> findUserById(Long id);


}
