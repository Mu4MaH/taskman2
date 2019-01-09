package org.alex.service;

import org.alex.api.service.ITaskService;
import org.alex.entity.Task;
import org.alex.exception.IllegalCallParameterException;
import org.alex.exception.IllegalStringException;
import org.alex.repository.TaskRepository;

import java.util.List;

public class TaskService implements ITaskService {

    private final TaskRepository taskRepository = new TaskRepository();

    public void deleteTask(String uid) throws IllegalStringException {
        if (uid != "" && uid != null) {
            taskRepository.deleteTask(uid);
        } else {
            throw new IllegalStringException();
        }
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new NullPointerException();
        } else {
            taskRepository.addTask(task);
        }
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public Task getTask(String uid) throws IllegalStringException {
        if (uid != "" && uid != null) {
            return taskRepository.getTask(uid);
        } else {
            throw new IllegalStringException();
        }
    }

    public void updateTask(String uid, Task task) throws IllegalCallParameterException {
        if (uid != "" && uid != null && task != null) {
            taskRepository.updateTask(uid, task);
        } else {
            throw new IllegalCallParameterException();
        }
    }

}
