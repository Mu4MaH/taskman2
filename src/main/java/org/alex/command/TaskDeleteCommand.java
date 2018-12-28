package org.alex.command;

import org.alex.controller.Bootstrap;

public class TaskDeleteCommand extends AbstractCommand {
    final public String description = "Remove task from list by id";
    final public String command = "task-del";

    public String getCommand() {
        return command;
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        System.out.print("Enter uid of task to delete: ");
        final String strHelper = bootstrap.getString();
        bootstrap.taskService.deleteTask(strHelper);
    }

}
