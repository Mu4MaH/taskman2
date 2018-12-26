package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Project;
import org.alex.repository.ProjectRepository;
import org.alex.service.ProjectService;

import java.util.Scanner;

public class ProjectCreateCommand extends AbstractCommand {

    public final String description = "Create new project";
    private final String command = "project-create";
    private final ProjectService projectService = new ProjectService();

    public ProjectCreateCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        System.out.println(description);
        bootstrap.projectService.getRepo().addProject(new Project(new Scanner(System.in).nextLine()));
        System.out.println("done..");
    }

    public String getCommand() {
        return this.command;
    }

}
