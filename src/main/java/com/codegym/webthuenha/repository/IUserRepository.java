package com.codegym.webthuenha.repository;

import com.codegym.webthuenha.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    @Query(value = "SELECT * FROM users where username = :usersname ", nativeQuery = true)
    Optional<User> checkDoubleUser(@Param("usersname") String username);

    @Query(value = "select * from users where id = :id", nativeQuery = true)
    Optional<User> getUserByid(@Param("id") Long id);
}