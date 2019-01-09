package org.alex.controller;

import org.alex.entity.Assignee;
import org.alex.entity.Session;

import java.util.List;

public class AuthorizationController {

    public void login(Bootstrap bootstrap) throws Exception {
        System.out.println("-= Система управления задачами вер. 2.0.0 приветствует вас =-\n");

        while (true) {
            System.out.println("Пожалуйста авторизуйтесь");
            System.out.print("Введите имя входа пользователя (cancel - выход из программы): ");
            String strHelper = bootstrap.getString();
            if ("cancel".equals(strHelper.toLowerCase())) System.exit(99);
            final List<Assignee> listHelper = bootstrap.getAssigneeService().getAllAssignee();
            for (Assignee assignee : listHelper) {
                System.out.println(assignee.getLogin() + " ### " + strHelper);
                if (assignee.getLogin().equals(strHelper)) {
                    for (int i = 3; i > 0; i--) {
                        System.out.print("У вас осталось " + i + ((i == 1) ? " попытка" : " попытки") + " ввода пароля. Введите пароль: ");
                        strHelper = bootstrap.getString();
                        if (assignee.getPassHash() == strHelper.hashCode()) {
                            System.out.println("Здравствуйте, " + assignee.getName() + "\n");
                            bootstrap.execute(new Session(assignee.getUid(), assignee.getLogin()));
                            return;
                        }
                    }
                }
            }
            System.out.println("Нет такого пользователя \n");
        }
    }

}



