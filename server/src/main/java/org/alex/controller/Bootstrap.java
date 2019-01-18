package org.alex.controller;

import org.alex.api.service.*;
import org.alex.command.AbstractCommand;
import org.alex.command.HelpCommand;
import org.alex.command.LogoutCommand;
import org.alex.command.QuitCommand;
import org.alex.command.assignee.AssigneeCreateCommand;
import org.alex.command.assignee.AssigneeDeleteCommand;
import org.alex.command.assignee.AssigneeGetListCommand;
import org.alex.command.data.DataFlushToDiskCommand;
import org.alex.command.data.DataLoadFromDiskCommand;
import org.alex.command.data.DataLoadFromJsonCommand;
import org.alex.command.data.DataSaveToJsonCommand;
import org.alex.command.project.ProjectCreateCommand;
import org.alex.command.project.ProjectGetListCommand;
import org.alex.command.project.ProjectGetWorkersCommand;
import org.alex.command.task.*;
import org.alex.endpoint.EndpointAssigneeService;
import org.alex.endpoint.EndpointAssignmentService;
import org.alex.endpoint.EndpointProjectService;
import org.alex.endpoint.EndpointTaskService;
import org.alex.entity.Assignee;
import org.alex.entity.Domain;
import org.alex.entity.Project;
import org.alex.entity.Session;
import org.alex.service.*;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.xml.ws.Endpoint;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Bootstrap {


    private final static Class[] COMMANDS = {AssigneeCreateCommand.class, AssigneeDeleteCommand.class, AssigneeGetListCommand.class,
            DataFlushToDiskCommand.class, DataLoadFromDiskCommand.class, DataSaveToJsonCommand.class, DataLoadFromJsonCommand.class,
            ProjectCreateCommand.class, ProjectGetListCommand.class, ProjectGetWorkersCommand.class, TaskCreateCommand.class, TaskDeleteCommand.class,
            TaskGetListCommand.class, TaskGetWorkersCommand.class, TaskViewCommand.class, HelpCommand.class, LogoutCommand.class, QuitCommand.class};


    private final ITaskService taskService = new TaskService();
    private final IProjectService projectService = new ProjectService();
    private final IAssigneeService assigneeService = new AssigneeService();
    private final IAssignmentService assignmentService = new AssignmentService();
    private final EndpointTaskService endpointTaskService = new EndpointTaskService();
    private final EndpointProjectService endpointProjectService = new EndpointProjectService();
    private final EndpointAssigneeService endpointAssigneeService = new EndpointAssigneeService();
    private final EndpointAssignmentService endpointAssignmentService = new EndpointAssignmentService();
    private final IAccessControlService accessControlService = new SecurityService(this);
    private final Scanner scanner = new Scanner(System.in);
    private final Domain domain = new Domain();
    private final int MAX_AUTH_TRIES = 3;
    private final Map<String, AbstractCommand> commandMap = new HashMap<>();

    private String loggedAssigneeId;
    private SecretKey masterSecretKey = null;

    public Bootstrap() throws NoSuchAlgorithmException, NoSuchPaddingException {
    }


    /*** -= Test data Block =- ***/

    public void testFill() {
        assigneeService.create(new Assignee());
        projectService.create(new Project("Project1"));
        projectService.create(new Project("Project2"));
        projectService.create(new Project("Project3"));
    }

    /***/

    public void authorize() throws Exception {
        System.out.print("Введите имя входа пользователя (cancel - выход из программы): ");
        final String loginConsole = getNextLine();
        if ("cancel".equals(loginConsole.toLowerCase())) System.exit(99);
        final List<Assignee> listHelper = getAssigneeService().getAll();
        for (Assignee assignee : listHelper) {
//            System.out.println("DEBUG: " + assignee.getLogin() + " ### " + loginConsole);
            if (loginConsole.equals(assignee.getLogin()))
                for (int i = 0; i < MAX_AUTH_TRIES; i++) {
                    System.out.print("У вас осталось " + (MAX_AUTH_TRIES - i) + ((i == 2) ? " попытка" : " попытки")
                            + " ввода пароля. Введите пароль: ");
                    final String passwordConsole = getNextLine();
                    if (assignee.getPassword() == passwordConsole.hashCode()) {
                        Session session = new Session();
                        System.out.println("Здравствуйте, " + assigneeService.get(assignee.getUid()) + "\n");
                        createCommands(COMMANDS);
                        launch(assignee.getUid());
                        return;
                    }
                }
        }
        System.out.println("Нет такого пользователя \n");
        authorize();

    }

    public void launch(String loggedAssigneeId) throws Exception {
//        Endpoint.publish("http://localhost:888/tm", new Bootstrap());
        createCommands(COMMANDS);
        this.loggedAssigneeId = loggedAssigneeId;
        System.out.println(" -= Добро пожаловать в консоль управления задачами =-\n");
        System.out.println("DEBUG: " + loggedAssigneeId);
        System.out.println("Список команд:");
        for (AbstractCommand c : commandMap.values()) {
            System.out.println(c.getCommand() + " - " + c.getDescription());
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

    public String getNextLine() {
        return scanner.nextLine();
    }

    public Integer getNextInt() {
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

    public void logout() {
        loggedAssigneeId = null;
    }

    public Domain getDomain() {
        return domain;
    }

    public String getLoggedAssigneeId() {
        return loggedAssigneeId;
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

    public List<AbstractCommand> getCommands() {
        return (List<AbstractCommand>) commandMap.values();
    }

    private void createCommands(final Class ... classes) throws IllegalAccessException, InstantiationException {
        AbstractCommand claz;
        for (Class c: classes) {
            claz = (AbstractCommand)c.newInstance();
            commandMap.put (claz.getCommand(),claz);
        }
    }

    public void setMasterSecretKey (SecretKey secretKey) {
        this.masterSecretKey = secretKey;
    }

    public SecretKey getMasterSecretKey () {
        return this.masterSecretKey;
    }


}
