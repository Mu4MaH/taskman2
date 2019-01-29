package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;
import org.alex.entity.Session;

import java.util.List;

public class LoginCommand extends AbstractCommand {


    final private String command = "login";
    final private String description = "Вход в систему";
    private final int MAX_AUTH_TRIES = 3;

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute(Bootstrap bootstrap) throws Exception {
        System.out.print("Введите имя входа пользователя (cancel - выход из программы): ");
        final String loginConsole = bootstrap.getNextLine();
        if ("cancel".equals(loginConsole.toLowerCase())) System.exit(99);
        final List<Assignee> listHelper = bootstrap.getAssigneeService().getAllAssignee();
        for (Assignee assignee : listHelper) {
            System.out.println("DEBUG: " + assignee.getLogin() + " ### " + loginConsole);
            if (loginConsole.equals(assignee.getLogin()))
                for (int i = 0; i < MAX_AUTH_TRIES; i++) {
                    System.out.print("У вас осталось " + (MAX_AUTH_TRIES - i) + ((i == 2) ? " попытка" : " попытки")
                            + " ввода пароля. Введите пароль: ");
                    final String passwordConsole = bootstrap.getNextLine();
                    if (assignee.getPassword() == passwordConsole.hashCode()) {
                        System.out.println("Здравствуйте, " + bootstrap.getAssigneeService().getAssignee(assignee.getUid()) + "\n");
//                        bootstrap.generateToken(assignee.getUid());
                        bootstrap.launch(new Session());
                        return;
                    }
                }
        }
        System.out.println("Нет такого пользователя \n");
        execute(bootstrap);
    }

}
