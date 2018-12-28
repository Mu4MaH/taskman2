package org.alex.api.repository;

import org.alex.entity.Task;

import java.util.ArrayList;
import java.util.List;

public interface ITaskRepository {

    public void addTask(Task task);

    public Task getTask(String uid);

    public void updateTask(String uid, Task task);

    public void deleteTask(String uid);

    public List<Task> getAllTasks();

}
