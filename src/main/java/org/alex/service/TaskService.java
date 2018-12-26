package org.alex.service;

import org.alex.service.ProjectService;
import org.alex.repository.TaskRepository;

public class TaskService {

    private final TaskRepository taskRepository = new TaskRepository();

    public TaskRepository getRepo() {
        return this.taskRepository;
    }

}
