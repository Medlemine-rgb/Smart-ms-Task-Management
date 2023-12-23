package com.sid.TaskManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.TaskManagement.entities.Task;
import com.sid.TaskManagement.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public List<Task> findAll(){
        return taskRepository.findAll();
    }
    
    public Task create(Task task){
        return taskRepository.save(task);
    }

    public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
    }
    public Boolean delete(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public String update(Task task, Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task updatedtTask = taskOptional.get();

            updatedtTask.setTitle(task.getTitle());

            taskRepository.save(updatedtTask);
            return "task updated !";

        } else
            return "Old company not found !";
    }
    



    
}
