package com.sid.TaskManagement.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.TaskManagement.entities.User;
import com.sid.TaskManagement.services.UserService;

@RestController
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllUser());
    }
  
}
