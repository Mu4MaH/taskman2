package org.alex.repository;

import org.alex.api.repository.ITaskRepository;
import org.alex.entity.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskRepository implements ITaskRepository {

    private final Map<String, Task> tasks = new HashMap<>();

    @Override
    public void add(Task task) {
        this.tasks.put(task.getUid(), task);
    }

    @Override
    public Task get(String uid) {
        return this.tasks.get(uid);
    }

    @Override
    public void updateTask(String uid, Task task) {
        this.tasks.put(uid, task);
    }

    @Override
    public void delete(String uid) {
        this.tasks.remove(uid);
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList(this.tasks.values());
    }

    @Override
    public void merge(List<Task> tasks) {
        for (Task task : tasks)
            this.tasks.put(task.getUid(), task);
    }

}
