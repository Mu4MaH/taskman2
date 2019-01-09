package org.alex.api.service;

import org.alex.entity.Task;
import org.alex.exception.IllegalCallParameterException;
import org.alex.exception.IllegalStringException;

import java.util.List;

public interface ITaskService {

    public void deleteTask(String uid) throws IllegalStringException;

    public void addTask(Task task);

    public List<Task> getAllTasks();

    public Task getTask(String uid) throws IllegalStringException;

    public void updateTask(String uid, Task task) throws IllegalCallParameterException;

}
