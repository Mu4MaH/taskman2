package org.alex.service;

import org.alex.repository.ProjectRepository;
import org.alex.repository.TaskRepository;

public class InitService {
    TaskRepository taskRepository = new TaskRepository();
    ProjectRepository projectRepository = new ProjectRepository();
}
