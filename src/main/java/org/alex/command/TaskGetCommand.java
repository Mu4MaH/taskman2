package org.alex.command;

import org.alex.controller.Bootstrap;

public class TaskGetCommand extends AbstractCommand {

    final public String description = "List of tasks";
    final private String command = "task-get";

    public TaskGetCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println(description);
    }

    @Override
    public String command() {
        return command;
    }
}
