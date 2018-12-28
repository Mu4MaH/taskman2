package org.alex.api.service;

import org.alex.entity.Task;

import java.util.List;

public interface ITaskService {

    public void deleteTask(String uid);

    public void addTask(Task task);

    public List<Task> getAllTasks();

    public Task getTask(String uid);

    public void updateTask(String uid, Task task);

}
