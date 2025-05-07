package com.linkedin.taskmanager.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        Task task = new Task();
        task.setTitle("Test task");
        task.setStatus("To do");

        // act
        Task savedTask = taskRepository.save(task);

        // assert
        assertNotNull(savedTask);
        assertEquals("Test task", savedTask.getTitle());
    }
}
