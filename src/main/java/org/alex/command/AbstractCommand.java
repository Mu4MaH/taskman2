package org.alex.command;

import org.alex.controller.Bootstrap;

public abstract class AbstractCommand {
    protected Bootstrap bootstrap;
    String command;

    AbstractCommand() {
    }

    public abstract String getCommand();

    public abstract void execute(Bootstrap bootstrap);

}



