package org.alex.command.data;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;
import org.alex.entity.Project;
import org.alex.entity.Task;

import java.io.*;

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
        final Assignee[] assignees = bootstrap.getAssigneeService().getAllAssignee().toArray(new Assignee[0]);
        final Task[] tasks = bootstrap.getTaskService().getAllTask().toArray(new Task[0]);
        final Project[] projects = bootstrap.getProjectService().getAllProject().toArray(new Project[0]);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(projects);
            oos.writeObject(tasks);
            oos.writeObject(assignees);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка ввода/вывода");
        }
    }

}
