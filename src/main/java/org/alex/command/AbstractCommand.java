package org.alex.command;

import org.alex.controller.Bootstrap;

public abstract class AbstractCommand {
    protected Bootstrap bootstrap;
    private String command;
    private String description;

    AbstractCommand() {
    }

    public abstract String getCommand();

    public abstract String getDescription();

    public abstract void execute(Bootstrap bootstrap);

}



