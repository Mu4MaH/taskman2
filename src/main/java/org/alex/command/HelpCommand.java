package org.alex.command;

import org.alex.controller.Bootstrap;

public class HelpCommand extends AbstractCommand{

    final String description="Help topic";
    final String command="help";

    public HelpCommand(Bootstrap bootstrap) {
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
