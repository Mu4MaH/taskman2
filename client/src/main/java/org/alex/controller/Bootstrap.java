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
import org.alex.entity.Assignee;
import org.alex.entity.Domain;
import org.alex.entity.Project;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap {


    private final static Class[] COMMANDS = {AssigneeCreateCommand.class, AssigneeDeleteCommand.class, AssigneeGetListCommand.class,
            DataFlushToDiskCommand.class, DataLoadFromDiskCommand.class, DataSaveToJsonCommand.class, DataLoadFromJsonCommand.class,
            ProjectCreateCommand.class, ProjectGetListCommand.class, ProjectGetWorkersCommand.class, TaskCreateCommand.class, TaskDeleteCommand.class,
            TaskGetListCommand.class, TaskGetWorkersCommand.class, TaskViewCommand.class, HelpCommand.class, LogoutCommand.class, QuitCommand.class};



    private final EndpointTaskService endpointTaskService = (EndpointTaskService) new EndpointTaskServiceService();
    private final EndpointProjectService endpointProjectService = (EndpointProjectService) new EndpointProjectServiceService();
    private final EndpointAssigneeService endpointAssigneeService = (EndpointAssigneeService) new EndpointAssigneeServiceService();
    private final EndpointAssignmentService endpointAssignmentService = (EndpointAssignmentService) new EndpointAssignmentServiceService();
    private final Scanner scanner = new Scanner(System.in);
    private final int MAX_AUTH_TRIES = 3;
    private final Map<String, AbstractCommand> commandMap = new HashMap<>();

    private String loggedAssigneeId;
    private SecretKeySpec masterSecretKey = null;

    public Bootstrap() throws NoSuchAlgorithmException, NoSuchPaddingException {
    }

    public void launch() throws Exception {
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

    public void logout() {
        loggedAssigneeId = null;
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

    public void setMasterSecretKey (SecretKeySpec secretKeySpec) {
        this.masterSecretKey = secretKeySpec;
    }

    public SecretKey getMasterSecretKey () {
        return this.masterSecretKey;
    }


}
