package org.alex.command.task;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskGetListCommand extends AbstractCommand {

    public TaskGetListCommand() {
        super();
    }

    final public String description = "List of tasks";
    final private String command = "tl";

    @Override
    public void execute(Bootstrap bootstrap) {
        int id = 1;
        final List<Task> helperList = new ArrayList<>(bootstrap.getTaskService().getAllTasks());
        final String adminGroup = bootstrap.getAssigneeService().getAdminGroup();
        final String loggedUserId = bootstrap.getSession().getUserId();
        for (Task task : helperList) {
            if (loggedUserId.equals(task.getOwnerId()) || adminGroup.contains(loggedUserId))
                System.out.println(id++ + ". " + task.toString());
        }
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String getCommand() {
        return command;
    }

}
