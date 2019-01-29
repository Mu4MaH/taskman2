package org.alex.command.project;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.endpoint.Project;

import java.util.ArrayList;
import java.util.List;

public final class ProjectGetListCommand extends AbstractCommand {

    final public String description = "Показать список проектов.";
    final private String command = "pl";

    public ProjectGetListCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        int id = 1;
        final List<Project> helperList = new ArrayList<>(bootstrap.getProjectService().getEndpointProjectPort().getAllProject());
        final String adminGroup = bootstrap.getAssigneeService().getEndpointAssigneePort().getAdminGroup();
        final String loggedUserId = bootstrap.getLoggedAssigneeId();
        for (Project project : helperList) {
            if (loggedUserId.equals(project.getOwnerId()) || adminGroup.contains(loggedUserId))
             System.out.println(id++ + ". " + project.getName());
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
