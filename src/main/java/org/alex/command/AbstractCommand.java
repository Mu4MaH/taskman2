package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.repository.ProjectRepository;

public abstract class AbstractCommand {
    protected Bootstrap bootstrap;

    AbstractCommand() { }

    public AbstractCommand(Bootstrap bootstrap){
        this.bootstrap = bootstrap;
    }

    String command;

    abstract void execute(ProjectRepository projectRepository);


}



