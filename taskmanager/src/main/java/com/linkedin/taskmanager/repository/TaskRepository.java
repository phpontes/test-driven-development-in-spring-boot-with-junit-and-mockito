package com.linkedin.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.linkedin.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
