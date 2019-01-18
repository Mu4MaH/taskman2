package org.alex.command;

import org.alex.controller.Bootstrap;

public class HelpCommand extends AbstractCommand {

    final public String description = "Список команд.";
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
        System.out.println("Список команд:");
        for (AbstractCommand c : bootstrap.getCommands()) {
            System.out.println(c.getCommand() + " - " + c.getDescription());
        }
    }

}

