package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.repository.ProjectRepository;
import org.alex.service.Service;
public class ProjectCreateCommand extends AbstractCommand {

    public final String description = "Create new project";
    private final String command = "project-create";

    public ProjectCreateCommand(ProjectRepository projectRepository) {
        super();
    }

    public String getCommand() {
        return command;
    }


    void execute(ProjectRepository projectRepository) {
        projectRepository.addProject();
    }

}
