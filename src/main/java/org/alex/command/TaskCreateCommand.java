package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Task;
import org.alex.repository.ProjectRepository;
import org.alex.repository.TaskRepository;
import org.alex.service.TaskService;

import java.util.Scanner;

public class TaskCreateCommand extends AbstractCommand {

    final public String description = "Create new Task";
    final private String command = "task-create";

    public TaskCreateCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        final TaskRepository helperRepo = bootstrap.taskService.getRepo();
        System.out.print("Введите название задачи: ");
        final Task taskHelper = new Task(bootstrap.getString());
        helperRepo.addTask(taskHelper);
        final String uid = taskHelper.getUid();
        System.out.print("Хотите ввести все поля? y(д)/n(н)");
        if (bootstrap.getString().substring(0,1) == "y" || bootstrap.getString().substring(0,1) == "д") {
            System.out.print("Введите количество рабочих часов на выполнение задания: ");
            taskHelper.setHours(bootstrap.getInt());
            System.out.print("Введите имя исполнителя задачи: ");
            taskHelper.setWorker(bootstrap.getString());
            System.out.print("Введите приоритет задачи: ");
            taskHelper.setPriority(bootstrap.getString());
            bootstrap.taskService.getRepo().addTask(taskHelper);
        }
    }

    public String getCommand() {
        return command;
    }

}
