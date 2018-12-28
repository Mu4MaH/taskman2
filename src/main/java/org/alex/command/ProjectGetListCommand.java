package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Project;

import java.util.ArrayList;
import java.util.List;

public final class ProjectGetListCommand extends AbstractCommand {

    final public String description = "Get Project List";
    final private String command = "project-list";

    public ProjectGetListCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        int id = 1;
        final List<Project> helperList = new ArrayList<>(bootstrap.projectService.getAllProjects());
        for (Project project : helperList) {
            System.out.println(project.toString());
        }
    }

    public String getCommand() {
        return this.command;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
