package org.alex.service;

import org.alex.api.service.ITaskService;
import org.alex.entity.Task;
import org.alex.exception.IllegalArgumentException;
import org.alex.repository.TaskRepository;
import org.jetbrains.annotations.NotNull;

import javax.jws.WebService;
import java.sql.Connection;
import java.util.List;

public class TaskService implements ITaskService {

    private final TaskRepository repository = new TaskRepository();

    public TaskService(){

    }

    public void setConnection(@NotNull final Connection connection) {
        repository.setConnection(connection);
    }

    public void createTask(@NotNull final Task task) {
        if (task == null) {
            return;
        } else {
            repository.add(task);
        }
    }

    @Override
    public Task getTask(@NotNull final String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            return repository.get(uid);
        }
    }

    public List<Task> getAllTask() {
        return repository.getAll();
    }

    public void updateTask(@NotNull final String uid, @NotNull Task task) throws IllegalArgumentException {
        if (uid.isEmpty() || uid.equals(null) || task.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            repository.updateTask(uid, task);
        }
    }

    @Override
    public void mergeTask(@NotNull final List<Task> tasks) {
        if (tasks == null) return;
        repository.merge(tasks);
    }

    public void deleteTask(@NotNull final String uid) throws IllegalArgumentException {
        if (uid.isEmpty() && uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            repository.delete(uid);
        }
    }

}
