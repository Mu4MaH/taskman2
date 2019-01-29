package org.alex.command.project;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;

public class ProjectGetWorkersCommand extends AbstractCommand {

    private final String command = "pw";
    private final String description = "Получить список работников по проекту.";

    public ProjectGetWorkersCommand() {
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
