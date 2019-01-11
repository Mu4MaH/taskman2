package org.alex.api.service;

import org.alex.entity.Task;
import org.alex.exception.IllegalArgumentException;
import org.alex.exception.IllegalStringException;

import java.util.List;

public interface ITaskService {

    void deleteTask(String uid) throws IllegalArgumentException;

    void addTask(Task task);

    List<Task> getAllTasks();

    Task getTask(String uid) throws IllegalArgumentException;

    void updateTask(String uid, Task task) throws IllegalArgumentException;

    void mergeTasks(List<Task> tasks);
}
