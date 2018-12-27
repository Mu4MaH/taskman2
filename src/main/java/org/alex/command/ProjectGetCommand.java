package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Project;
import org.alex.repository.ProjectRepository;
import org.alex.service.ProjectService;

import java.util.Map;

public final class ProjectGetCommand extends AbstractCommand{

    final public String description = "Get Project List";
    final private String command = "project-list";

    public ProjectGetCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        int id = 1;
        final ProjectRepository repoHelper = bootstrap.projectService.getRepo();
        for (String key : repoHelper.getProjects().keySet()) {
            System.out.println(id++ + ". " + repoHelper.getProjects().get(key));

        }
    }

    public String getCommand(){
        return this.command;
    }

}
