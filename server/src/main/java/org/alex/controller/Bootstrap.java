
package org.alex.controller;

import org.alex.api.service.*;
import org.alex.command.AbstractCommand;
import org.alex.command.HelpCommand;
import org.alex.command.LogoutCommand;
import org.alex.command.QuitCommand;
import org.alex.command.assignee.AssigneeAssignProject;
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
import org.alex.entity.Session;
import org.alex.repository.ProjectRepository;
import org.alex.service.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hibernate.cfg.Configuration;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Reader;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Named
@RequestScoped
public class Bootstrap {

    private final String USER = "postgres";
    private final String PASS = "qwerty";
    private final String ADDR = "jdbc:postgresql://localhost:5432/postgres";
    private Connection connection;

    private final static Class[] COMMANDS = {AssigneeAssignProject.class, AssigneeCreateCommand.class, AssigneeDeleteCommand.class, AssigneeGetListCommand.class,
            DataFlushToDiskCommand.class, DataLoadFromDiskCommand.class, DataSaveToJsonCommand.class, DataLoadFromJsonCommand.class,
            ProjectCreateCommand.class, ProjectGetListCommand.class, ProjectGetWorkersCommand.class, TaskCreateCommand.class, TaskDeleteCommand.class,
            TaskGetListCommand.class, TaskGetWorkersCommand.class, TaskViewCommand.class, HelpCommand.class, LogoutCommand.class, QuitCommand.class};

    /*Hibernate config start */
    Configuration cfg = new Configuration()
            .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
            .setProperty("hibernate.connection.datasource", "jdbc:postgresql://localhost:5432/postgres")
            .setProperty("hibernate.order_updates", "true")
            .setProperty("hibernate.connection.username", "postgres")
            .setProperty("hibernate.connection.password", "qwerty")
            .setProperty("hibernate.show_sql", "true")
            .setProperty("hibernate.hbm2ddl.auto", "update");

//    SessionFactory sessions = cfg.buildSessionFactory();

    /*  -= End of Hibernate config =-  */

    private ITaskService taskService = new TaskService();
    private IProjectService projectService = new ProjectService();
    private final IAssigneeService assigneeService = new AssigneeService();
    private final IAssignmentService assignmentService = new AssignmentService();
    private final EndpointTask endpointTask = new EndpointTask(this);
    private final EndpointProject endpointProject = new EndpointProject(this);
    private final EndpointAssignee endpointAssignee = new EndpointAssignee(this);
    private final EndpointAssignment endpointAssignment = new EndpointAssignment(this);
    private final EndpointAuthorization endpointAuthorization = new EndpointAuthorization(this);
    private final IAccessControlService accessControlService = new SecurityService(this);
    private final AuthorizationService authorizationService = new AuthorizationService(this);
    private final Scanner scanner = new Scanner(System.in);
    private final Domain domain = new Domain();
    private final int MAX_AUTH_TRIES = 3;
    private final Map<String, AbstractCommand> commandMap = new HashMap<>();

    final Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
    final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    final SqlSession session = sqlSessionFactory.openSession();

    private String loggedAssigneeId;
    private SecretKey masterSecretKey = null;

    public Bootstrap() throws NoSuchAlgorithmException, NoSuchPaddingException, InstantiationException, IllegalAccessException, IOException {
    }

    {
        AbstractCommand claz;
        for (Class c : COMMANDS) {
            claz = (AbstractCommand) c.newInstance();
            commandMap.put(claz.getCommand(), claz);
        }
        try {
            connection = DriverManager.getConnection(ADDR, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Не могу подключиться к БД: " + ADDR);
        }
        session.getConfiguration().addMapper(ProjectRepository.class);
        taskService.setConnection(connection);
        assigneeService.setConnection(connection);
        assignmentService.setConnection(connection);
        projectService.setSessionFactory(sqlSessionFactory );
    }

    public void init() throws Exception {
        authorize();
    }

    public void authorize() throws Exception {
        System.out.print("Введите имя входа пользователя (cancel - выход из программы): ");
        final String loginConsole = getNextLine();
        if ("cancel".equals(loginConsole.toLowerCase())) System.exit(99);
        if (authorizationService.loginCheck(loginConsole)) {
            for (int i = 0; i < MAX_AUTH_TRIES; i++) {
                Assignee ass = assigneeService.getAssigneeByLogin(loginConsole);
                System.out.print("У вас осталось " + (MAX_AUTH_TRIES - i) + ((i == 2) ? " попытка" : " попытки")
                        + " ввода пароля. Введите пароль: ");
                final String passwordConsole = getNextLine();
                if (authorizationService.passwordCheck(loginConsole, passwordConsole.hashCode())) {
                    Session session = new Session();
                    session.setUserId(ass.getUid());
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
        this.loggedAssigneeId = session.getUserId();
        System.out.println(" -= Добро пожаловать в консоль управления задачами =-\n");
//        System.out.println("DEBUG: " + loggedAssigneeId);
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

    public void logout() throws Exception {
        loggedAssigneeId = null;
        authorize();
    }

    public Domain getDomain() {
        return domain;
    }

    public String getLoggedAssigneeId() {
        return loggedAssigneeId;
    }

    public TaskService getTaskService() {
        return (TaskService) this.taskService;
    }

    public ProjectService getProjectService() {
        return (ProjectService) this.projectService;
    }

    public AssigneeService getAssigneeService() {
        return (AssigneeService) this.assigneeService;
    }

    public AssignmentService getAssignmentService() {
        return (AssignmentService) this.assignmentService;
    }

    public Collection<AbstractCommand> getCommands() {
        return commandMap.values();
    }

    public AuthorizationService getAuthorizationService() {
        return authorizationService;
    }

    public void setMasterSecretKey(SecretKey secretKey) {
        this.masterSecretKey = secretKey;
    }

    public SecretKey getMasterSecretKey() {
        return this.masterSecretKey;
    }


}
