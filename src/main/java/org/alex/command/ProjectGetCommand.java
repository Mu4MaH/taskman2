package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.repository.ProjectRepository;
import org.alex.service.ProjectService;

public final class ProjectGetCommand extends AbstractCommand{

    final public String description = "Get Project List";
    final public String command = "project-list";

    private final ProjectService projectService = new ProjectService();

    public ProjectGetCommand() {
    }

    @Override
    public void execute() {
        System.out.println(description);
    }

}
