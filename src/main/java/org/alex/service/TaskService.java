package org.alex.service;

import org.alex.api.service.ITaskService;
import org.alex.entity.Project;
import org.alex.entity.Task;
import org.alex.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TaskService implements ITaskService {

    private final TaskRepository taskRepository = new TaskRepository();

    public void deleteTask(String uid) {
        taskRepository.deleteTask(uid);
    }

    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public Task getTask(String uid) {
        return taskRepository.getTask(uid);
    }

    public void updateTask(String uid, Task task) {
        taskRepository.updateTask(uid, task);

    }
}
