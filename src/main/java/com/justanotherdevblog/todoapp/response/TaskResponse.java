package com.justanotherdevblog.todoapp.response;

import java.util.UUID;

public class TaskResponse {

    private UUID id;
    private String description;

    public TaskResponse(UUID id, String description) {
        this.id = id;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
