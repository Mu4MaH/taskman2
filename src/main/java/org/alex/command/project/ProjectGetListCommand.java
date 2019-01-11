package org.alex.command.project;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.entity.Project;

import java.util.ArrayList;
import java.util.List;

public final class ProjectGetListCommand extends AbstractCommand {

    final public String description = "Get Project List";
    final private String command = "pl";

    public ProjectGetListCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        int id = 1;
        final List<Project> helperList = new ArrayList<>(bootstrap.getProjectService().getAllProjects());
        final String adminGroup = bootstrap.getAssigneeService().getAdminGroup();
        final String loggedUserId = bootstrap.getSession().getUserId();
        for (Project project : helperList) {
            if (loggedUserId.equals(project.getOwnerId()) || adminGroup.contains(loggedUserId))
             System.out.println(id++ + ". " + project.toString());
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
