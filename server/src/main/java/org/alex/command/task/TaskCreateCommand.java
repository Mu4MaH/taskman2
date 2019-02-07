package org.alex.command.task;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.entity.Task;

public class TaskCreateCommand extends AbstractCommand {

    final private String description = "Создать новую задачу.";

    final private String command = "tc";

    public TaskCreateCommand() {
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        System.out.print("Введите название задачи: ");
        final Task helperTask = new Task(bootstrap.getNextLine());
//        final String uid = helperTask.getUid();
        String owner = bootstrap.getLoggedAssigneeId();
        helperTask.setOwnerId(owner);
        System.out.print("Хотите ввести все поля? y(д) - да/энтер - нет");
        final String choice = bootstrap.getNextLine();
        if ("y".equals(choice) || "д".equals(choice)) {
            System.out.print("Введите количество рабочих часов на выполнение задания: ");
            helperTask.setHours(bootstrap.getNextInt());
            System.out.print("Введите приоритет задачи: \n    1.IDLE \n    2.NORMAL \n    3.URGENT \n    4.FATAL \n>");
            final int tempInt = (bootstrap.getNextInt());
            switch (tempInt) {
                case 1:
                    helperTask.setPriority("idle");
                    break;
                case 2:
                    helperTask.setPriority("normal");
                    break;
                case 3:
                    helperTask.setPriority("urgent");
                    break;
                case 4:
                    helperTask.setPriority("fatal");
                    break;
            }
            bootstrap.getTaskService().createTask(helperTask);
        } else {
            helperTask.setHours(8);
            helperTask.setPriority("idle");
            bootstrap.getTaskService().createTask(helperTask);
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
