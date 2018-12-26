package org.alex.controller;

import org.alex.command.*;
import org.alex.entity.Task;
import org.alex.repository.ProjectRepository;
import org.alex.repository.TaskRepository;
import org.alex.service.ProjectService;
import org.alex.service.TaskService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap {
    public final TaskService taskService = new TaskService();
    public final ProjectService projectService = new ProjectService();

    private final Scanner sc = new Scanner(System.in);

    Map<String, AbstractCommand> commandMap = new HashMap<>();
    HelpCommand helpCommand = new HelpCommand();
    ProjectCreateCommand projectCreateCommand = new ProjectCreateCommand();
    ProjectGetCommand projectGetCommand = new ProjectGetCommand();
    TaskCreateCommand taskCreateCommand = new TaskCreateCommand();
    TaskGetCommand taskGetCommand = new TaskGetCommand();
    QuitCommand quitCommand = new QuitCommand();

    public void execute() throws Exception {
        this.register();
        System.out.println("-= Task manager v.2.0.0 greets you =-");
        System.out.println("List of commands: \n help - show this list.\n project-create - create new project. \n project-list - view all projects. \n task-create - create new task.\n task-get - view task by it's name \n quit");
        while (true) {
            System.out.print("Enter your command > ");
            final String cmd = sc.nextLine();
            if (!commandMap.containsKey(cmd));
            else {
                commandMap.get(cmd).execute(this);
            }
        }
    }

    public void register() {
        commandMap.put(helpCommand.command, helpCommand);
        commandMap.put(projectCreateCommand.getCommand(), projectCreateCommand);
        commandMap.put(projectGetCommand.getCommand(), projectGetCommand);
        commandMap.put(taskCreateCommand.getCommand(), taskCreateCommand);
        commandMap.put(taskGetCommand.getCommand(), taskGetCommand);
        commandMap.put(quitCommand.getCommand(),quitCommand);
    }


}
