package org.alex.command.assignee;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;
import org.alex.entity.Assignment;
import org.alex.entity.Project;

import java.util.ArrayList;
import java.util.List;

public class AssigneeAssignProject extends AbstractCommand {

    final String command = "ap";
    final String description = "Назначить работника на проект";

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute(Bootstrap bootstrap) throws Exception {
        System.out.println("Выберите проект на который назначаем работника: ");
        int number = 0;
        final List<Project> projectList = new ArrayList<>(bootstrap.getProjectService().getAllProject());
        for (Project project : projectList) {
            System.out.println(number++ + "." + project.toString());
        }
        final int pos = bootstrap.getNextInt();
        if (pos > projectList.size()) return;
        String targetProjectId = projectList.get(pos - 1).getUid();
        System.out.println("Выберите работника которого назначаем на проект: ");
        number = 0;
        final List<Assignee> assigneeList = new ArrayList<>(bootstrap.getAssigneeService().getAllAssignee());
        for (Assignee assignee : assigneeList) {
            System.out.println(number++ + ". " + assignee.getName());
        }
        final int worker = bootstrap.getNextInt();
        if (worker > assigneeList.size()) return;
        String workerId = assigneeList.get(worker - 1).getUid();
        Assignment assignment = new Assignment();
        assignment.setAssignmentId(targetProjectId);
        assignment.setAssigningId(workerId);
        bootstrap.getAssignmentService().assigneeToProject(assignment);

    }
}
