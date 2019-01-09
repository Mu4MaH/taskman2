package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Task;

public class TaskCreateCommand extends AbstractCommand {

    final public String description = "Create new Task";
    final private String command = "tc";

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
            System.out.print("Введите приоритет задачи: \n    1.IDLE \n    2.NORMAL \n    3.URGENT \n    4.FATAL \n>");
            int tempInt = (bootstrap.getInt());
            taskHelper.setPriority(tempInt);
            bootstrap.getTaskService().addTask(taskHelper);
        } else {
            taskHelper.setHours(8);
            taskHelper.setPriority(1);
            bootstrap.getTaskService().addTask(taskHelper);
        }
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
