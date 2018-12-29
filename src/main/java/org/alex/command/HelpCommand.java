package org.alex.command;

import org.alex.controller.Bootstrap;

public class HelpCommand extends AbstractCommand {

    final public String description = "Help topic";
    final public String command = "help";

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        System.out.println("List of commands: \n help - show this list.\n project-create - create new project. \n project-list - view all projects. \n task-create - create new task.\n task-get - view task by it's name \n quit");
        //TODO: когда все команды будут автозаноситься в мапу то пробежать по мапе и выдать getCommand() + " - " getDescription вместо этих сосисок!!!!
    }

}

