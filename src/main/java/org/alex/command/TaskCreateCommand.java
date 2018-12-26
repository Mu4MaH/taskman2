package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Task;
import org.alex.repository.ProjectRepository;
import org.alex.service.TaskService;

import java.util.Scanner;

public class TaskCreateCommand extends AbstractCommand {

    final public String description = "Create new Task";
    final private String command = "task-create";

    public TaskCreateCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) throws Exception {
        System.out.print("Введите название задачи: ");
        Scanner sc = new Scanner(System.in);
        Task taskHelper = new Task(sc.nextLine());
        bootstrap.taskService.getRepo().addTask(taskHelper);
        String uid = taskHelper.getUid();
        System.out.print("Хотите ввести все поля? y(д)/n(н)");
        if (sc.nextLine().substring(0,1) == "y" || sc.nextLine().substring(0,1) == "д") {
            System.out.print("Введите количество рабочих часов на выполнение задания: ");
            taskHelper.setHours(Integer.parseInt(sc.nextLine()));
            System.out.print("Введите имя исполнителя задачи: ");
            taskHelper.setWorker(sc.nextLine());
            System.out.print("Введите приоритет задачи: ");
            taskHelper.setPriority(sc.nextLine());
            bootstrap.taskService.getRepo().updateTask(uid, taskHelper);
        }
    }

    public String getCommand() {
        return command;
    }

}
