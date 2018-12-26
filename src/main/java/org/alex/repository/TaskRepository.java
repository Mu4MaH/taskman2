package org.alex.repository;

import org.alex.entity.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskRepository {

    private final Map<String, Task> taskMap = new HashMap<>();

    public void addTask (Task task) {
        taskMap.put(task.getUid(),task);
    }

    public Task getTaskByUid (String uid) {
        return taskMap.get(uid);
    }

    public HashMap<String, Task> getAllTasks () {
        Map<String, Task> output = new HashMap<>();
        if (taskMap.isEmpty()) return (HashMap<String, Task>) output;
        else {
            int id = 0;
            for (String key : taskMap.keySet())
                output.put(key,taskMap.get(key));
        }
        return (HashMap<String, Task>) output;
    }

    public void deleteTask (String uid) {
        taskMap.remove(uid);
    }

    public void updateTask (String uid, Task task) {
        task.setUid(uid);
        taskMap.put(uid, task);
    }

}
