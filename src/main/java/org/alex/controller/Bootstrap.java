package org.alex.controller;

import org.alex.command.*;
import org.alex.service.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap {

    public final TaskService taskService = new TaskService();
    public final TasksFlushDataService tasksFlushDataService = new TasksFlushDataService();
    public final ProjectService projectService = new ProjectService();
    public final ProjectsFlushDataService projectsFlushDataService = new ProjectsFlushDataService();
    public final AssigneeService assigneeService = new AssigneeService();
    public final AssigneeFlushDataService assigneeFlushDataService = new AssigneeFlushDataService();
    public final AssigneeFlushToDiskCommand assigneeFlushToDiskCommand = new AssigneeFlushToDiskCommand();
    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, AbstractCommand> commandMap = new HashMap<>();
    private final HelpCommand helpCommand = new HelpCommand();
    private final ProjectCreateCommand projectCreateCommand = new ProjectCreateCommand();
    private final ProjectGetListCommand projectGetCommand = new ProjectGetListCommand();
    private final TaskCreateCommand taskCreateCommand = new TaskCreateCommand();
    private final TaskGetListCommand taskGetCommand = new TaskGetListCommand();
    private final TaskDeleteCommand taskDeleteCommand = new TaskDeleteCommand();
    private final AssigneeCreateCommand assigneeCreateCommand = new AssigneeCreateCommand();
    private final AssigneeDeleteCommand assigneeDeleteCommand = new AssigneeDeleteCommand();
    private final AssigneeGetListCommand assigneeGetListCommand = new AssigneeGetListCommand();
    private final QuitCommand quitCommand = new QuitCommand();

    public void execute() {
        this.register();
        System.out.println("-= Task manager v.2.0.0 greets you =-");
        System.out.println("List of commands: \n help - show this list.\n " +
                "project-create - create new project. \n " +
                "project-list - view all projects. \n " +
                "task-create - create new task.\n " +
                "task-get - view task by it's name (unready) \n " +
                "task-del - Remove task from list by id \n " +
                "assignee-create - create worker \n " +
                "worker-del - Erases worker everywhere.. \n " +
                "worker-list - Get list of workers \n " +
                "assignee-flush - write assignees to disk \n " +
                "quit");
        while (true) {
            System.out.print("Enter your command > ");
            final String cmd = scanner.nextLine();
            if (!commandMap.containsKey(cmd)) ;
            else {
                commandMap.get(cmd).execute(this);
            }
        }
    }

    public String getString() {
        return scanner.nextLine();
    }

    public Integer getInt() {
        final String input;
        final int output;
        input = scanner.nextLine();
        try {
            output = Integer.parseInt(input);
        } catch (Exception e) {
            return null;
        }
        return output;
    }

    public void register() {

        commandMap.put(helpCommand.command, helpCommand);
        commandMap.put(projectCreateCommand.getCommand(), projectCreateCommand);
        commandMap.put(projectGetCommand.getCommand(), projectGetCommand);
        commandMap.put(taskCreateCommand.getCommand(), taskCreateCommand);
        commandMap.put(taskGetCommand.getCommand(), taskGetCommand);
        commandMap.put(quitCommand.getCommand(), quitCommand);
        commandMap.put(taskDeleteCommand.getCommand(), taskDeleteCommand);
        commandMap.put(assigneeDeleteCommand.getCommand(), assigneeDeleteCommand);
        commandMap.put(assigneeGetListCommand.getCommand(), assigneeGetListCommand);
        commandMap.put(assigneeCreateCommand.getCommand(), assigneeCreateCommand);
        commandMap.put(assigneeFlushToDiskCommand.getCommand(), assigneeFlushToDiskCommand);
    }

}
