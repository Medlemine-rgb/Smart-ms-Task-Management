package com.sid.TaskManagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sid.TaskManagement.entities.User;
import com.sid.TaskManagement.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public User createuser(User user) {
        return userRepository.save(user);
      }

    public List<User> getAllUser() {
        return userRepository.findAll();

    }

    
}
