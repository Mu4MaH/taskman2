package org.alex.repository;

import org.alex.api.repository.ITaskRepository;
import org.alex.entity.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskRepository implements ITaskRepository {

    private final Map<String, Task> tasks = new HashMap<>();


    public void addTask(Task task) {
        tasks.put(task.getUid(), task);
    }

    public Task getTask(String uid) {
        return tasks.get(uid);
    }

    public void updateTask(String uid, Task task) {
        tasks.put(uid, task);
    }

    public void deleteTask(String uid) {
        tasks.remove(uid);
    }

    public List<Task> getAllTasks() {
        return new ArrayList(tasks.values());
    }

}
