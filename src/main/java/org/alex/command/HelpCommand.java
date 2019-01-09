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
        bootstrap.getHelp();
    }

}

