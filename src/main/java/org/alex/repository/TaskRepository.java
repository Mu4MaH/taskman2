package org.alex.repository;

import org.alex.entity.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskRepository {

    private final Map<String, Task> tasks = new HashMap<>();

    public Map<String, Task> getRepo() {
        return this.tasks;
    }

    public void addTask(Task task) {
        tasks.put(task.getUid(),task);
    }

    public Task getTask(String uid) {
        return tasks.get(uid);
    }

    public void updateTask(String uid, Task task) {
        tasks.put(uid, task);
    }

    public void deleteTask (String uid) {
        tasks.remove(uid);
    }

}
