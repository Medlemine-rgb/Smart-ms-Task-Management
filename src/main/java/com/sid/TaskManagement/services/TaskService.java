package com.sid.TaskManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.TaskManagement.entities.Task;
import com.sid.TaskManagement.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
      }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }
    
    public Task create(Task task){
        return taskRepository.save(task);
    }

    /* @Transactional(readOnly =  true)
    public List<Task> getTasks(){

        return taskRepository.findAll();
    } */

	/* public Task save(Task task) {
		return taskRepository.save(task);
	} */
    



    
}
