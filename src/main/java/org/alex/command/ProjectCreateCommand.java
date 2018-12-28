package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Project;
import org.alex.repository.ProjectRepository;
import org.alex.service.ProjectService;

public class ProjectCreateCommand extends AbstractCommand {

    public final String description = "Create new project";
    private final String command = "project-create";
    private final ProjectService projectService = new ProjectService();

    public ProjectCreateCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        System.out.println(description);
        final ProjectRepository repoHelper = bootstrap.projectService.getRepo();
        final String projName = bootstrap.getString();
        repoHelper.addProject(new Project(projName));
        System.out.println("done..");
    }

    public String getCommand() {
        return this.command;
    }

}
