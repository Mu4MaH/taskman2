package org.alex.command;

import org.alex.controller.Bootstrap;

public class TaskCreateCommand extends AbstractCommand {

    final public String description = "Create new Task";
    final private String command = "task-create";

    public TaskCreateCommand(Bootstrap bootstrap) {
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
