package com.justanotherdevblog.todoapp.repository;

import com.justanotherdevblog.todoapp.model.Task;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TaskRepository {

    private TaskJDBIRepository taskJDBIRepository;

    public TaskRepository(Jdbi jdbi) {
        this.taskJDBIRepository = jdbi.onDemand(TaskJDBIRepository.class);
    }

    public Task insertTask(String description) {
        return taskJDBIRepository.insertTask(description);
    }

    public Task findById(UUID taskId) {
        return taskJDBIRepository.findById(taskId);
    }
}
