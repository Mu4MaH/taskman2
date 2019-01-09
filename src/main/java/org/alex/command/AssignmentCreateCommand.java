package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignment;
import org.alex.entity.Project;
import org.alex.entity.Task;

import java.util.ArrayList;
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
    public void execute(Bootstrap bootstrap) throws Exception {
        //базовый не подходит, нужна перегрузка
    }

    public void execute(Bootstrap bootstrap, String idAssigner) throws Exception {
        String helperStr;
        System.out.println("Куда назначать? \n 1.Проект \n 2.ЗАдача");
        int choice = bootstrap.getInt();
        int i;
        List<?> helperList; //TODO: <?>
        if (choice == 1) {
            helperList = (ArrayList<Project>) bootstrap.getProjectService().getAllProjects();
            for (i = 0; i < helperList.size(); i++) {
                System.out.println(i + 1 + ". " + helperList.get(i).toString());
            }
        } else {
            helperList = (ArrayList<Task>) bootstrap.getTaskService().getAllTasks();
            for (i = 0; i < helperList.size(); i++) {
                System.out.println(i + 1 + ". " + helperList.get(i).toString());
            }
        }
        System.out.print("Введите номер позиции: ");
        choice = bootstrap.getInt();
        //bootstrap.getAssignmentService().create(new Assignment(helperList.get(i-1), idAssigner));
    }

}
