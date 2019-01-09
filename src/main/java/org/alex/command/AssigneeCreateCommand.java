package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;

public class AssigneeCreateCommand extends AbstractCommand {

    final private String command = "ac";
    final private String description = "Creates new assignee";

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
        helperAss.setName(bootstrap.getString());
        System.out.println("Введите логин пользователя");
        helperAss.setLogin(bootstrap.getString());
        System.out.println("Введите пароль пользователя");
        helperAss.setPassword(bootstrap.getString());
        bootstrap.getAssigneeService().addAssignee(helperAss);
    }

}

