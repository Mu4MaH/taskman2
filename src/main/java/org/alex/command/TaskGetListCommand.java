package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskGetListCommand extends AbstractCommand {

    final public String description = "List of tasks";
    final private String command = "tl";

    public TaskGetListCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        int id = 1;
        final List<Task> helperList = new ArrayList<>(bootstrap.getTaskService().getAllTasks());
        for (Task task : helperList) {
            System.out.println(task.toString());
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
