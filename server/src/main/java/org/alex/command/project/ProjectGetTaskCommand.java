package org.alex.command.project;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;

public class ProjectGetTaskCommand extends AbstractCommand {

    private final String command = "pt";
    private final String description = "Получить список задач на проекте";

    public ProjectGetTaskCommand() {
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
