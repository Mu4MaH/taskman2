package org.alex.command.task;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.endpoint.IllegalArgumentException_Exception;
import org.alex.endpoint.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDeleteCommand extends AbstractCommand {
    final public String description = "Удалить задачу.";
    final public String command = "td";

    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute(Bootstrap bootstrap) throws IllegalArgumentException, IllegalArgumentException_Exception {
        int n = 1;
        final List<Task> helperList = new ArrayList<>(bootstrap.getTaskService().getEndpointTaskPort().getAllTask());
        final String adminGroup = bootstrap.getAssigneeService().getEndpointAssigneePort().getAdminGroup();
        final String loggedUserId = bootstrap.getLoggedAssigneeId();
        final boolean inAdmins = adminGroup.contains(loggedUserId);
        if (inAdmins)
            for (Task task : helperList) {
                System.out.println(n++ + ". " + task.toString());
            }
        System.out.print("Введите номер задачи для удаления: ");
        int id = bootstrap.getNextInt();
        if (id > helperList.size()) {
            return;
        } else {
            String strId = helperList.get(id - 1).getUid();
            bootstrap.getTaskService().getEndpointTaskPort().deleteTask(strId);
        }
    }

}
