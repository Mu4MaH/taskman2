package org.alex.controller;

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
import org.alex.endpoint.*;
import org.alex.entity.Domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap {


    private final static Class[] COMMANDS = {AssigneeCreateCommand.class, AssigneeDeleteCommand.class, AssigneeGetListCommand.class,
            DataFlushToDiskCommand.class, DataLoadFromDiskCommand.class, DataSaveToJsonCommand.class, DataLoadFromJsonCommand.class,
            ProjectCreateCommand.class, ProjectGetListCommand.class, ProjectGetWorkersCommand.class, TaskCreateCommand.class, TaskDeleteCommand.class,
            TaskGetListCommand.class, TaskGetWorkersCommand.class, TaskViewCommand.class, HelpCommand.class, LogoutCommand.class, QuitCommand.class};

    private final EndpointTaskService endpointTaskService = new EndpointTaskService();
    private final EndpointProjectService endpointProjectService = new EndpointProjectService();
    private final EndpointAssigneeService endpointAssigneeService = new EndpointAssigneeService();
    private final EndpointAssignmentService endpointAssignmentService = new EndpointAssignmentService();
    private final EndpointAuthorizationService endpointAuthorizationService = new EndpointAuthorizationService();

    private final Scanner scanner = new Scanner(System.in);
    private final int MAX_AUTH_TRIES = 3;
    private final Map<String, AbstractCommand> commandMap = new HashMap<>();
    private final Domain domain = new Domain();

    private String loggedAssigneeId;

    public Bootstrap() {
    }

    public void authorize() throws Exception {
        System.out.print("Введите имя входа пользователя (cancel - выход из программы): ");
        final String loginConsole = getNextLine();
        if ("cancel".equals(loginConsole.toLowerCase())) System.exit(99);
        if (  endpointAuthorizationService.getEndpointAuthorizationPort().loginCheck(loginConsole)) {
            for (int i = 0; i < MAX_AUTH_TRIES; i++) {
                Assignee ass = endpointAssigneeService.getEndpointAssigneePort().getAssigneeByLogin(loginConsole);
                System.out.print("У вас осталось " + (MAX_AUTH_TRIES - i) + ((i == 2) ? " попытка" : " попытки")
                        + " ввода пароля. Введите пароль: ");
                final String passwordConsole = getNextLine();
                if (endpointAuthorizationService.getEndpointAuthorizationPort().passwordCheck(loginConsole, passwordConsole.hashCode())) {
                    Session session = new Session();
                    session.setUserId(ass.getUid());
                    loggedAssigneeId = session.getUserId();
                    System.out.println("Здравствуйте, " + ass.getName() + "\n");
                    launch(session);
                    return;
                }
            }
        }

        System.out.println("Нет такого пользователя \n");
        authorize();
    }


    public void launch(Session session) throws Exception {
        createCommands(COMMANDS);
        System.out.println(" -= Добро пожаловать в консоль управления задачами =-\n");
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

    public String logout() throws GeneralSecurityException_Exception, UnsupportedEncodingException_Exception {
        Session session = new Session();
        session.setUserId(loggedAssigneeId);
        loggedAssigneeId = null;
        return endpointAuthorizationService.getEndpointAuthorizationPort().createToken(session);
    }

    public Domain getDomain() {
        return domain;
    }

    public String getLoggedAssigneeId() {
        return loggedAssigneeId;
    }

    public EndpointTaskService getTaskService() {
        return this.endpointTaskService;
    }

    public EndpointProjectService getProjectService() {
        return this.endpointProjectService;
    }

    public EndpointAssigneeService getAssigneeService() {
        return this.endpointAssigneeService;
    }

    public EndpointAssignmentService getAssignmentService() {
        return this.endpointAssignmentService;
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

    public void setLoggedAssigneeId(String loggedAssigneeId) {
        this.loggedAssigneeId = loggedAssigneeId;
    }

}
