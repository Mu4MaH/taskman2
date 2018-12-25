package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.repository.ProjectRepository;

public class HelpCommand extends AbstractCommand {

    final public String description = "Help topic";
    final public String command = "help";

    public HelpCommand() {
    }

    @Override
    public void execute() {
        System.out.println("List of commands: \n help - show this list.\n project-create - create new project. \n project-list - view all projects. \n task-create - create new task.\n task-get - view task by it's name \n quit");

    }
}

