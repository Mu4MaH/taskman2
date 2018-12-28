package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;

public class AssigneeCreateCommand extends AbstractCommand {

    final private String command = "assignee-create";
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
        System.out.print("Введите имя работника: ");
        final String strHelper = bootstrap.getString();
        bootstrap.assigneeService.addAssignee(new Assignee(strHelper));
    }

}

