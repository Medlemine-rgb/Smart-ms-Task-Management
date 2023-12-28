package com.sid.TaskManagement;

import com.sid.TaskManagement.entities.Task;
import com.sid.TaskManagement.repository.TaskRepository;
import com.sid.TaskManagement.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Arrange
        List<Task> taskList = new ArrayList<>();
        when(taskRepository.findAll()).thenReturn(taskList);

        // Act
        List<Task> result = taskService.findAll();

        // Assert
        assertEquals(taskList, result);
    }

    @Test
    void testCreate() {
        // Arrange
        Task task = new Task();
        when(taskRepository.save(task)).thenReturn(task);

        // Act
        Task result = taskService.create(task);

        // Assert
        assertEquals(task, result);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void testFindById() {
        // Arrange
        Long taskId = 1L;
        Task task = new Task();
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        // Act
        Optional<Task> result = taskService.findById(taskId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(task, result.get());
    }

    @Test
    void testDelete() {
        // Arrange
        Long taskId = 1L;
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(new Task()));

        // Act
        Boolean result = taskService.delete(taskId);

        // Assert
        assertTrue(result);
        verify(taskRepository, times(1)).deleteById(taskId);
    }

    @Test
    void testDeleteTaskNotFound() {
        // Arrange
        Long taskId = 1L;
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());

        // Act
        Boolean result = taskService.delete(taskId);

        // Assert
        assertFalse(result);
        verify(taskRepository, never()).deleteById(taskId);
    }

    @Test
    void testUpdate() {
        // Arrange
        Long taskId = 1L;
        Task existingTask = new Task();
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(existingTask));

        Task updatedTask = new Task();
        updatedTask.setTitle("Updated Title");

        // Act
        String result = taskService.update(updatedTask, taskId);

        // Assert
        assertEquals("Task updated !", result);
        assertEquals("Updated Title", existingTask.getTitle());
        verify(taskRepository, times(1)).save(existingTask);
    }

    @Test
    void testUpdateTaskNotFound() {
        // Arrange
        Long taskId = 1L;
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());

        Task updatedTask = new Task();
        updatedTask.setTitle("Updated Title");

        // Act
        String result = taskService.update(updatedTask, taskId);

        // Assert
        assertEquals("Old task not found !", result);
        verify(taskRepository, never()).save(any());
    }
}
