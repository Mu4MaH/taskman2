package org.alex.api.service;

import org.alex.entity.Task;
import org.alex.exception.IllegalArgumentException;

import java.util.List;

public interface ITaskService {

    void delete(String uid) throws IllegalArgumentException;

    void create(Task task);

    List<Task> getAll();

    Task get(String uid) throws IllegalArgumentException;

    void updateTask(String uid, Task task) throws IllegalArgumentException;

    void merge(List<Task> tasks);
}
