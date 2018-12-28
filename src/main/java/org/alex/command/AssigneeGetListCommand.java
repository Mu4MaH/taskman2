package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;

import java.util.ArrayList;
import java.util.List;

public class AssigneeGetListCommand extends AbstractCommand {

    private final String command = "assignee-list";
    private final String description = "Command to get list of assignees";

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        int id = 1;
        final List<Assignee> helperList = new ArrayList<>(bootstrap.assigneeService.getAllAssignee());
        for (Assignee assignee : helperList) {
            System.out.println(assignee.toString());
        }
    }

}


