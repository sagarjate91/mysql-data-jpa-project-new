package com.annotation.mysql_data_jpa_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.annotation.mysql_data_jpa_project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   
   Optional<User> findByEmail(String email);

    
}
