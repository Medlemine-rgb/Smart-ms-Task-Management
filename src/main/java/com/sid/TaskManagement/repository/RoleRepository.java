package com.sid.TaskManagement.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.TaskManagement.entities.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}