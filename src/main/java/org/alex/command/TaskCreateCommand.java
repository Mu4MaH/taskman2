package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Task;

public class TaskCreateCommand extends AbstractCommand {

    final public String description = "Create new Task";
    final private String command = "task-create";

    public TaskCreateCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        System.out.print("Введите название задачи: ");
        final Task taskHelper = new Task(bootstrap.getString());
        final String uid = taskHelper.getUid();
        System.out.print("Хотите ввести все поля? y(д)/n(н)");
        final char choice = bootstrap.getString().charAt(0);
        if (choice == 'y' || choice == 'д') {
            System.out.print("Введите количество рабочих часов на выполнение задания: ");
            taskHelper.setHours(bootstrap.getInt());
            System.out.print("Введите имя исполнителя задачи: ");
            taskHelper.setWorker(bootstrap.getString());
            System.out.print("Введите приоритет задачи: \n    1.IDLE \n    2.NORMAL \n    3.URGENT \n    4.FATAL \n>");
            taskHelper.setPriority(bootstrap.getString());
            bootstrap.taskService.addTask(taskHelper);
        } else {
            taskHelper.setHours(8);
            taskHelper.setWorker("unset");
            taskHelper.setPriority("IDLE");
            bootstrap.taskService.addTask(taskHelper);
        }
    }

    public String getCommand() {
        return command;
    }

}
