package com.sid.TaskManagement.web;

import org.springframework.web.bind.annotation.RestController;
import com.sid.TaskManagement.entities.Task;
import com.sid.TaskManagement.services.TaskService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



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
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getTaskByID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletetask(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.delete(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatetask(@RequestBody Task task, @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(task, id));
    }
    
   
    
}
