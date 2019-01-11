package org.alex.service;

import org.alex.api.service.ITaskService;
import org.alex.entity.Task;
import org.alex.exception.IllegalArgumentException;
import org.alex.exception.IllegalStringException;
import org.alex.repository.TaskRepository;

import java.util.List;

public class TaskService implements ITaskService {

    private final TaskRepository taskRepository = new TaskRepository();

    public void deleteTask(String uid) throws IllegalArgumentException {
        if (uid.isEmpty() && uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            taskRepository.deleteTask(uid);
        }
    }

    public void addTask(Task task) {
        if (task == null) {
            return;
        } else {
            taskRepository.addTask(task);
        }
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    @Override
    public Task getTask(String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            return taskRepository.getTask(uid);
        }
    }

    public void updateTask(String uid, Task task) throws IllegalArgumentException {
        if (uid.isEmpty() || uid.equals(null) || task.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            taskRepository.updateTask(uid, task);
        }
    }

    @Override
    public void mergeTasks(List<Task> tasks) {
        if (tasks == null) return;
        taskRepository.mergeTasks(tasks);
    }

}
