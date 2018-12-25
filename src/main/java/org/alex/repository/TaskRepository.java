package org.alex.repository;

import org.alex.entity.Task;

import java.util.Map;

public class TaskRepository {

    private Map<String, Task> taskMap;
    private Task tasks = new Task();

    public void addTask (Task task) {
        taskMap.put(task.getUid(),task);
    }

    public Task getTaskByUid (String uid) {
        return (Task) taskMap.get(uid);
    }

    public void viewAllTasks () {
        if (taskMap.isEmpty()) System.out.println("No active tasks.");
        else {
            int id = 0;
            for (String key : taskMap.keySet())
                System.out.println(id++ + " " + taskMap.get(key).toString());
        }
        System.out.println();
    }

    public void deleteTask (String uid) {
        taskMap.remove(uid);
    }

}
