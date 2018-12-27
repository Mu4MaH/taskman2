package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Task;
import org.alex.repository.ProjectRepository;
import org.alex.repository.TaskRepository;
import org.alex.service.TaskService;

import java.util.HashMap;
import java.util.Map;

public class TaskGetCommand extends AbstractCommand {

    final public String description = "List of tasks";
    final private String command = "task-get";

    public TaskGetCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        int id = 1;
        System.out.println(description);
        final TaskRepository helperRepo = bootstrap.taskService.getRepo();
        for (String key: helperRepo.getRepo().keySet()) {
            System.out.println(id++ +". " + helperRepo.getRepo().get(key));
        }
    }

    public String getCommand() {
        return command;
    }

}
