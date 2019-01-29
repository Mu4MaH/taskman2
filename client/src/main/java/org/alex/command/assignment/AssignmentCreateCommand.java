package org.alex.command.assignment;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.endpoint.Assignee;
import org.alex.endpoint.Assignment;
import org.alex.endpoint.Project;
import org.alex.endpoint.Task;

import java.util.List;

public class AssignmentCreateCommand extends AbstractCommand {

    final private String command = "assign";

    final private String description = "Прикрепляет испонителя к проекту, задачу к проекту, исполнителя к задаче.";

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute(final Bootstrap bootstrap) throws Exception {
        int i;
        int select;
        System.out.println("Выберите номер пользователя из списка:");
        final List<Assignee> assignees = bootstrap.getAssigneeService().getEndpointAssigneePort().getAllAssignee();
        i = 0;
        for (Assignee a : assignees) {
            i++;
            System.out.println(i + ". " + a.getName());
        }
        select = bootstrap.getNextInt();
        final String idAssigner = assignees.get(select - 1).getUid();
        System.out.println("Куда назначать? \n 1.Проект \n 2.Задача");
        final int choice = bootstrap.getNextInt();
        if (choice == 1) {
            final List<Project> projects = bootstrap.getProjectService().getEndpointProjectPort().getAllProject();
            i = 0;
            for (Project p : projects) {
                i++;
                System.out.println(i + ". " + p.getName());
            }
            System.out.print("Введите номер позиции: ");
            select = bootstrap.getNextInt();
            Assignment assignmentHelper = new Assignment();
            assignmentHelper.setFromId(projects.get(select - 1).getUid());
            assignmentHelper.setToId(idAssigner);
            bootstrap.getAssignmentService().getEndpointAssignmentPort().createAssignment(assignmentHelper);
        } else {
            final List<Task> tasks = bootstrap.getTaskService().getEndpointTaskPort().getAllTask();
            i = 0;
            for (Task t : tasks) {
                i++;
                System.out.println(i + ". " + t.getName() + " : " + bootstrap.getAssigneeService().getEndpointAssigneePort().getAssignee(t.getOwnerId()));
            }
            System.out.print("Введите номер позиции: ");
            select = bootstrap.getNextInt();
            Assignment assignmentHelper = new Assignment();
            assignmentHelper.setFromId(tasks.get(select - 1).getUid());
            assignmentHelper.setToId(idAssigner);
            bootstrap.getAssignmentService().getEndpointAssignmentPort().createAssignment(assignmentHelper);
        }
    }

}
