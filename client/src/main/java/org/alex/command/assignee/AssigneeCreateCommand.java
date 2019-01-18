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
        System.out.println("Введите логин пользователя");
        helperAss.setLogin(bootstrap.getNextLine());
        System.out.println("Введите пароль пользователя");
        helperAss.setPassword(bootstrap.getNextLine());
        helperAss.setGroup("users");
        bootstrap.getAssigneeService().create(helperAss);
    }

}

