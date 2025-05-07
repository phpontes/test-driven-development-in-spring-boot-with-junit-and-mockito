package com.linkedin.taskmanager.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.linkedin.taskmanager.model.Task;

@DataJpaTest
public class TaskRepositoryTest {
    
    @Autowired
    TaskRepository taskRepository;

    @Test
    void testSaveTask() {
        // arrange
        Task task = new Task("Test task", "To do");

        // act
        Task savedTask = taskRepository.save(task);

        // assert
        assertNotNull(savedTask);
        assertEquals("Test task", savedTask.getTitle());
    }

    @Test
    void testDeleteTask() {
        // arrange
        Task task = new Task("Task to delete", "Done");
        taskRepository.save(task);

        // act
        taskRepository.delete(task);
        Optional<Task> deletedTask = taskRepository.findById(task.getId());

        // assert
        assertFalse(deletedTask.isPresent());
    }
}
