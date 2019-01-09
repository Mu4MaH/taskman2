package org.alex.controller;

import org.alex.api.service.*;
import org.alex.command.*;
import org.alex.entity.Assignee;
import org.alex.entity.Project;
import org.alex.entity.Session;
import org.alex.entity.Task;
import org.alex.service.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap {

    private final ITaskService taskService = new TaskService();
    private final IProjectService projectService = new ProjectService();
    private final IAssigneeService assigneeService = new AssigneeService();
    private final IAssignmentService assignmentService = new AssignmentService();
    private final IAccessControlService accessControlService = new AccessControlService();
    private Session session;
    private final Scanner scanner = new Scanner(System.in);

    /*Commands block*/
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
    private final DataFlushToDiskCommand dataFlushToDiskCommand = new DataFlushToDiskCommand();
    private final DataLoadFromDiskCommand dataLoadFromDiskCommand = new DataLoadFromDiskCommand();
    private final LogoutCommand logoutCommand = new LogoutCommand();
    /*End of commands block*/

    /*** -= Test data Block =- ***/
    public void testFill() {
        assigneeService.addAssignee(new Assignee());
        projectService.addProject(new Project("Project1"));
        projectService.addProject(new Project("Project2"));
        projectService.addProject(new Project("Project3"));
        taskService.addTask(new Task());
    }

    /***/

    public void execute(Session session) throws Exception {
        this.session = session;
        this.register();
        System.out.println(" -= Добро пожаловать в консоль управления задачами =-\n");
        System.out.println("Список команд:");
        for (String key : commandMap.keySet()
        ) {
            System.out.println(key + " - " + commandMap.get(key).getDescription());
        }
        while (true) {
            System.out.print("Введите команду> ");
            final String cmd = scanner.nextLine();
            if (!commandMap.containsKey(cmd)) ;
            else {
                commandMap.get(cmd).execute(this);
            }
        }
    }

    /* -= Safe scanners =- */

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

    /***************/

    public void clearSession() {
        this.session = null;
    }

    public void getHelp() {
        System.out.println("Список команд:");
        for (String key : commandMap.keySet()
        ) {
            System.out.println(key + " - " + commandMap.get(key).getDescription());
        }
    }

    public Session getSession() {
        return session;
    }

    public ITaskService getTaskService() {
        return this.taskService;
    }

    public IProjectService getProjectService() {
        return this.projectService;
    }

    public IAssigneeService getAssigneeService() {
        return this.assigneeService;
    }

    public IAssignmentService getAssignmentService() {
        return this.assignmentService;
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
        commandMap.put(dataFlushToDiskCommand.getCommand(), dataFlushToDiskCommand);
        commandMap.put(dataLoadFromDiskCommand.getCommand(), dataLoadFromDiskCommand);
        commandMap.put(logoutCommand.getCommand(), logoutCommand);
    }

}
