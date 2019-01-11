package org.alex.api.repository;

import org.alex.entity.Task;

import java.util.List;

public interface ITaskRepository {

    void addTask(Task task);

    Task getTask(String uid);

    void updateTask(String uid, Task task);

    void deleteTask(String uid);

    List<Task> getAllTasks();

    void mergeTasks(List<Task> tasks);

}
