package org.alex.command.data;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;
import org.alex.entity.Project;
import org.alex.entity.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DataLoadFromDiskCommand extends AbstractCommand {

    private final String command = "load";
    private  final String description = "Быстрая загрузка с диска. Из .tm файла.";

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
        final File file;
        //TODO: выбор файла с фс пользователем
        file = new File("./data.tm");
        final FileInputStream fis = new FileInputStream(file);
        final ObjectInputStream ois = new ObjectInputStream(fis);
        final Project[] projects = (Project[]) ois.readObject();
        final Task[] tasks = (Task[]) ois.readObject();
        final Assignee[] assignees = (Assignee[]) ois.readObject();
        ois.close();
        fis.close();
    }
}
