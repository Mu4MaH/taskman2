package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Project;
import org.alex.service.ProjectService;

import java.util.Map;

public final class ProjectGetCommand extends AbstractCommand{

    final public String description = "Get Project List";
    final private String command = "project-list";

    private final ProjectService projectService = new ProjectService();

    public ProjectGetCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        int id = 1;
        System.out.println(description);
        Map<String, Project> helperMap = bootstrap.projectService.getRepo().getAllTasks();
        for (String key : helperMap.keySet()) {
            System.out.println(id++ + ". " + helperMap.get(key));

        }
    }

    public String getCommand(){
        return this.command;
    }

}
