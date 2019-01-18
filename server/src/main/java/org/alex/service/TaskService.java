package org.alex.service;

import org.alex.api.service.AbstractService;
import org.alex.api.service.ITaskService;
import org.alex.entity.Task;
import org.alex.exception.IllegalArgumentException;
import org.alex.repository.TaskRepository;

import javax.jws.WebService;
import java.util.List;

@WebService
public class TaskService extends AbstractService<Task> implements ITaskService {

    private final TaskRepository repository = new TaskRepository();


    public void create(Task task) {
        if (task == null) {
            return;
        } else {
            repository.add(task);
        }
    }

    @Override
    public Task get(String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            return repository.get(uid);
        }
    }

    public List<Task> getAll() {
        return repository.getAll();
    }

    public void updateTask(String uid, Task task) throws IllegalArgumentException {
        if (uid.isEmpty() || uid.equals(null) || task.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            repository.updateTask(uid, task);
        }
    }

    @Override
    public void merge(List<Task> tasks) {
        if (tasks == null) return;
        repository.merge(tasks);
    }

    public void delete(String uid) throws IllegalArgumentException {
        if (uid.isEmpty() && uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            repository.delete(uid);
        }
    }

}
