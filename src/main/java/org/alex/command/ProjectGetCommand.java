package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.repository.ProjectRepository;

public final class ProjectGetCommand extends AbstractCommand{

    final public String description = "Get Project List";

    final private String command = "project-list";

    public ProjectGetCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    void execute(ProjectRepository projectRepository) {

    }

}
