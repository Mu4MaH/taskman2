package org.alex.controller;

import org.alex.entity.Assignee;
import org.alex.entity.Session;

import java.util.List;

public class AuthorizationController {

    private final int MAX_AUTH_TRIES = 3;

    public void authorize(Bootstrap bootstrap) throws Exception {
        System.out.print("Введите имя входа пользователя (cancel - выход из программы): ");
        final String loginConsole = bootstrap.getNextLine();
        if ("cancel".equals(loginConsole.toLowerCase())) System.exit(99);
        final List<Assignee> listHelper = bootstrap.getAssigneeService().getAllAssignee();
        for (Assignee assignee : listHelper) {
            System.out.println(assignee.getLogin() + " ### " + loginConsole);
            if (loginConsole.equals(assignee.getLogin()))
                for (int i = 0; i < MAX_AUTH_TRIES; i++) {
                    System.out.print("У вас осталось " + (MAX_AUTH_TRIES - i) + ((i == 2) ? " попытка" : " попытки")
                            + " ввода пароля. Введите пароль: ");
                    final String passwordConsole = bootstrap.getNextLine();
                    if (assignee.getPassword() == passwordConsole.hashCode()) {
                        System.out.println("Здравствуйте, " + assignee.getUid() + "\n");
                        bootstrap.launch(new Session(assignee.getUid()));
                        return;
                    }
                }
        }
        System.out.println("Нет такого пользователя \n");
        bootstrap.start();
    }

}



