package org.alex.service;

import org.alex.api.service.ITaskService;
import org.alex.entity.Task;
import org.alex.repository.TaskRepository;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
@Transactional
public class TaskService implements ITaskService {

    public TaskService(){}

    @Inject
    private TaskRepository repo;

    public void createTask(@NotNull final Task task) {
        repo.save(task);
    }

    @Override
    @Nullable
    public Task getTask(@NotNull final String uid){
        if (uid.isEmpty()) {
            return null;
        } else {
            return repo.findBy(uid);
        }
    }

    @NotNull public List<Task> getAllTask() {
        return repo.findAll();
    }

    public void updateTask(@NotNull Task task){
            repo.save(task);
    }

    @Override
    public void mergeTasks(@NotNull final List<Task> tasks) {
        final List<Task> helperList = repo.findAll();
        for (Task t: helperList) {
            repo.remove(t);
        }
        for (Task t : tasks) {
            repo.save(t);
        }
    }

    public void deleteTask(@NotNull final String uid) {
            repo.remove(repo.findBy(uid));
    }

}
