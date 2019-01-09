package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Project;

public class ProjectCreateCommand extends AbstractCommand {

    public final String description = "Create new project";
    private final String command = "pc";
    public ProjectCreateCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        System.out.print("Введите название проекта: ");
        final String tempStr = bootstrap.getString();

        final Project projectHelper = new Project(tempStr);
        projectHelper.setAuthor(bootstrap.getSession().getUserId());
        bootstrap.getProjectService().addProject(projectHelper);
        System.out.println("Проект с названием " + tempStr + " создан.");
    }

    public String getCommand() {
        return this.command;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
