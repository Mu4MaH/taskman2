package org.alex.command.project;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.entity.Project;

public class ProjectCreateCommand extends AbstractCommand {

    public final String description = "Создать новый проект.";
    private final String command = "pc";
    public ProjectCreateCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        System.out.print("Введите название проекта: ");
        final String tempStr = bootstrap.getNextLine();

        final Project projectHelper = new Project(tempStr);
        projectHelper.setOwnerId(bootstrap.getLoggedAssigneeId());
        bootstrap.getProjectService().createProject(projectHelper);
        System.out.println("Проект с названием " + tempStr + " создан.");
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
