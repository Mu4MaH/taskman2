package org.alex.api.repository;

import org.alex.entity.Task;

import java.util.List;

public interface ITaskRepository {

    void add(Task task);

    Task get(String uid);

    void updateTask(Task task);

    void delete(String uid);

    List<Task> getAll();
}
