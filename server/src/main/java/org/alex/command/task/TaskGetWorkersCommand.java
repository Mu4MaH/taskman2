package org.alex.command.task;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;

public class TaskGetWorkersCommand extends AbstractCommand {

    private final String command = "tw";
    private final String description = "Показать список работников по задаче.";

    public TaskGetWorkersCommand() {
    }

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


    }

}
