package org.alex.endpoint;

import org.alex.controller.Bootstrap;
import org.alex.entity.Task;
import org.alex.exception.IllegalArgumentException;
import org.alex.service.TaskService;
import org.jetbrains.annotations.NotNull;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class EndpointTask {

    private TaskService taskService;

    public EndpointTask() {
    }

    public EndpointTask(@NotNull Bootstrap bootstrap) {
       Endpoint.publish("http://localhost:888/task", this);
        taskService = bootstrap.getTaskService();
    }

    @WebMethod
    public void createTask(@NotNull Task task) {
        if (task == null) {
            return;
        } else {
            taskService.createTask(task);
        }
    }

    @WebMethod
    public Task getTask(@NotNull String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            return taskService.getTask(uid);
        }
    }

    @WebMethod
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }

    @WebMethod
    public void updateTask(@NotNull String uid, @NotNull Task task) throws IllegalArgumentException {
        if (uid.isEmpty() || uid.equals(null) || task.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            taskService.updateTask(uid, task);
        }
    }

    @WebMethod
    public void mergeTask(@NotNull List<Task> tasks) {
        if (tasks == null) return;
        taskService.mergeTask(tasks);
    }

    @WebMethod
    public void deleteTask(@NotNull String uid) throws IllegalArgumentException {
        if (uid.isEmpty() && uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            taskService.deleteTask(uid);
        }
    }

}
