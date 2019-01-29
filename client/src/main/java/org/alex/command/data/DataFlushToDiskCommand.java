package org.alex.command.data;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.endpoint.Assignee;
import org.alex.endpoint.Assignment;
import org.alex.endpoint.Project;
import org.alex.endpoint.Task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataFlushToDiskCommand extends AbstractCommand {

    final private String command = "save";
    final private String description = "Быстрое сохранение данных на диск в файл .tm";

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute(Bootstrap bootstrap) {

        final File file;
        file = new File("./data.tm");
        final Assignee[] assignees = bootstrap.getAssigneeService().getEndpointAssigneePort().getAllAssignee().toArray(new Assignee[0]);
        final Task[] tasks = bootstrap.getTaskService().getEndpointTaskPort().getAllTask().toArray(new Task[0]);
        final Project[] projects = bootstrap.getProjectService().getEndpointProjectPort().getAllProject().toArray(new Project[0]);
        final Assignment[] assignments = bootstrap.getAssignmentService().getEndpointAssignmentPort().getAllAssignment().toArray(new Assignment[0]);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(projects);
            oos.writeObject(tasks);
            oos.writeObject(assignees);
            oos.writeObject(assignments);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка ввода/вывода");
        }
    }

}
