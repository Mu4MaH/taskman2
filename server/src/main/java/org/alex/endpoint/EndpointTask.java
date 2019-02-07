package org.alex.endpoint;

import org.alex.controller.Bootstrap;
import org.alex.entity.Task;
import org.alex.service.TaskService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
            taskService.createTask(task);
    }

    @WebMethod
    @Nullable
    public Task getTask(@NotNull String uid){
        if (uid.isEmpty()) {
            return null;
        } else {
            return taskService.getTask(uid);
        }
    }

    @WebMethod
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }

    @WebMethod
    public void updateTask(@NotNull Task task){
            taskService.updateTask(task);
    }

    @WebMethod
    public void mergeTask(@NotNull List<Task> tasks) {
        taskService.mergeTasks(tasks);
    }

    @WebMethod
    public void deleteTask(@NotNull String uid){
        if (uid.isEmpty()) {
            return;
        } else {
            taskService.deleteTask(uid);
        }
    }

}
