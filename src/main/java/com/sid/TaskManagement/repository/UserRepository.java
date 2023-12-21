package com.sid.TaskManagement.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sid.TaskManagement.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Optional<User> findByUsername(String username);
    
    // Boolean existsByUsername(String username);
    
    // Boolean existsByEmail(String email);
    
    
}