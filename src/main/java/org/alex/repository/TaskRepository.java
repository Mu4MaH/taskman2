package org.alex.repository;

import org.alex.entity.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskRepository {

    private Map<String, Task> taskMap = new HashMap<>();
    private Task tasks = new Task();

    public void addTask (Task task) {
        taskMap.put(task.getUid(),task);
    }

    public Task getTaskByUid (String uid) {
        return (Task) taskMap.get(uid);
    }

    public Map<String, Task> getAllTasks () {
        Map<String, Task> output = new HashMap<>();
        if (taskMap.isEmpty()) return null;
        else {
            int id = 0;
            for (String key : taskMap.keySet())
                output.put(key,taskMap.get(key));
        }
        return output;
    }

    public void deleteTask (String uid) {
        taskMap.remove(uid);
    }

}
