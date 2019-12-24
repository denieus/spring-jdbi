package com.justanotherdevblog.todoapp.controller;

import com.justanotherdevblog.todoapp.model.Task;
import com.justanotherdevblog.todoapp.repository.TaskRepository;
import com.justanotherdevblog.todoapp.request.TaskRequest;
import com.justanotherdevblog.todoapp.response.TaskResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public TaskResponse addTask(@RequestBody TaskRequest request) {
        Task task = taskRepository.insertTask(request.getDescription());
        return new TaskResponse(task.getId(), task.getDescription());
    }

    @GetMapping("/{taskId}")
    public TaskResponse getTask(@PathVariable("taskId") UUID taskId) {
        Task task = taskRepository.findById(taskId);
        return new TaskResponse(task.getId(), task.getDescription());
    }

}