package org.alex.command.task;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskViewCommand extends AbstractCommand {

    final String command = "tv";

    final String description = "Посмотреть задачу.";

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute(Bootstrap bootstrap) throws Exception {
        int n = 1;
        final String adminGroup = bootstrap.getAssigneeService().getAssigneeAdminGroup();
        final String loggedUserId = bootstrap.getLoggedAssigneeId();
        final List<Task> helperList = new ArrayList<>(bootstrap.getTaskService().getAllTask());
        for (Task task : helperList) {
            if (task.getOwnerId().equals(loggedUserId) || adminGroup.contains(loggedUserId));
                System.out.println(n++ + ". " + task.getName());
        }
        System.out.print("Введите номер задачи для просмотра: ");
        int id = bootstrap.getNextInt();
        if (id > helperList.size()) return;
                else {
            String strId = helperList.get(id - 1).getName();
            System.out.println(bootstrap.getTaskService().getTask(strId).toString());
        }

    }
}
