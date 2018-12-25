package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Task;
import org.alex.repository.ProjectRepository;
import org.alex.service.TaskService;

import java.util.Scanner;

public class TaskCreateCommand extends AbstractCommand {

    final public String description = "Create new Task";
    final public String command = "task-create";

    final private TaskService taskService = new TaskService();
    public TaskCreateCommand() {
    }

    @Override
    public void execute() {
        taskService.taskRepository.addTask(new Task(new Scanner(System.in).nextLine()));
        System.out.println("done..");
    }

    public String command() {
        return command;
    }
}
