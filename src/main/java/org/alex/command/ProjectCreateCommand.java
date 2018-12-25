package org.alex.command;

import org.alex.repository.ProjectRepository;
import org.alex.service.ProjectService;

public class ProjectCreateCommand extends AbstractCommand {

    public final String description = "Create new project";
    public final String command = "project-create";
    private final ProjectService projectService = new ProjectService();

    public ProjectCreateCommand() {
    }

    @Override
    public void execute() {
        System.out.println(description);
    }

    public String getCommand() {
        return command;
    }

}
