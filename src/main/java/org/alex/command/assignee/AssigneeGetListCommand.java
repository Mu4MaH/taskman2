package org.alex.command.assignee;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;

import java.util.ArrayList;
import java.util.List;

public class AssigneeGetListCommand extends AbstractCommand {

    private final String command = "al";
    private final String description = "Command to get list of assignees";

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
        final List<Assignee> helperList = new ArrayList<>(bootstrap.getAssigneeService().getAllAssignee());
        for (Assignee assignee : helperList) {
            System.out.println(assignee.toString());
        }
    }

}


