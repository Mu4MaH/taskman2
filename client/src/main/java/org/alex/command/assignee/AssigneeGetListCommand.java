package org.alex.command.assignee;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.endpoint.Assignee;

import java.util.ArrayList;
import java.util.List;

public class AssigneeGetListCommand extends AbstractCommand {

    private final String command = "al";
    private final String description = "Получить список исполнителей.";

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
        int id = 1;
        final List<Assignee> helperList = new ArrayList<>(bootstrap.getAssigneeService().getEndpointAssigneePort().getAllAssignee());
        for (Assignee assignee : helperList) {
            System.out.println(id++ +". " + assignee.getName());
        }
    }

}


