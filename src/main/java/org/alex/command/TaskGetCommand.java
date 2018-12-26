package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Task;
import org.alex.repository.ProjectRepository;
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
        Map<String,Task> helperMap = bootstrap.taskService.getRepo().getAllTasks();
        for (String key: helperMap.keySet()) {
            System.out.println(id++ +". " + helperMap.get(key));
        }
    }

    public String getCommand() {
        return command;
    }

}
