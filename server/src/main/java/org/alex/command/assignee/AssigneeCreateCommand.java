package org.alex.command.assignee;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;

public class AssigneeCreateCommand extends AbstractCommand {

    final private String command = "ac";
    final private String description = "Создать учётную запись исполнителя.";

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        final Assignee helperAss = new Assignee();
        System.out.print("Введите имя работника: ");
        helperAss.setName(bootstrap.getNextLine());
        System.out.print("Введите логин пользователя: ");
        helperAss.setLogin(bootstrap.getNextLine());
        System.out.print("Введите пароль пользователя: ");
        helperAss.setPassword(bootstrap.getNextLine().hashCode());
        helperAss.setGroup("users");
        if (bootstrap.getAssigneeService().createAssignee(helperAss) == null) {
            System.out.println("Такой пользователь уже существует.");
            return;
        }
        System.out.println("Пользователь " + helperAss.getName() + " создан.");

    }

}

