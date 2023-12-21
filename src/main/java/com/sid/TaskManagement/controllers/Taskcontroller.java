package com.sid.TaskManagement.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.sid.TaskManagement.entities.Task;
import com.sid.TaskManagement.services.TaskService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/tasks")
// @CrossOrigin("*")
public class Taskcontroller {
    
    @Autowired
    private TaskService taskService;


    @PostMapping("/createTask")
    public ResponseEntity<Task> create(@RequestBody Task task ){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(task));
    }

     @GetMapping
    public ResponseEntity<List<Task>> getTask(){
            return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll());
        }
   /*  @GetMapping("/all")    
    public List<Task> getTask(){
        return taskService.getTasks();
    } */
   

   /*  @PostMapping("/create")
    public Task addTask( @RequestBody Task task ){

        return taskService.save(task);
    } */
    
   
    
}
