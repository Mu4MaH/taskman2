package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Task;
import org.alex.repository.ProjectRepository;
import org.alex.service.TaskService;

import java.util.HashMap;
import java.util.Map;

public class TaskGetCommand extends AbstractCommand {

    final public String description = "List of tasks";
    final public String command = "task-get";

    private final TaskService taskService = new TaskService();

    public TaskGetCommand() {
    }

    @Override
    public void execute() {
        int id = 1;
        System.out.println(description);
        Map<String,Task> helperMap = new HashMap<>(taskService.taskRepository.getAllTasks());
        for (String key: helperMap.keySet()) {
            System.out.println(id++ +". " + helperMap.get(key));
        }
    }

    public String command() {
        return command;
    }

}
