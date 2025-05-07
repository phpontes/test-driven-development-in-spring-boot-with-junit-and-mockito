package com.linkedin.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linkedin.taskmanager.model.Task;
import com.linkedin.taskmanager.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return tasks;
    }
}
