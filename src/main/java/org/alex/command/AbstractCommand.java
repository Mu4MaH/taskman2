package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.repository.ProjectRepository;

public abstract class AbstractCommand {
    protected Bootstrap bootstrap;

    AbstractCommand() { }

    String command;

    public abstract String getCommand();

    public abstract void execute(Bootstrap bootstrap);


}



