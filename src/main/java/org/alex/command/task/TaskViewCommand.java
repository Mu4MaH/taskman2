package org.alex.command.task;

import org.alex.command.AbstractCommand;
import org.alex.controller.Bootstrap;
import org.alex.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskViewCommand extends AbstractCommand {

    final String command = "tv";

    final String description = "Посмотреть задачу.";

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
        int n = 1;
        final List<Task> helperList = new ArrayList<>(bootstrap.getTaskService().getAllTasks());
        for (Task task : helperList) {
            if (task.getOwnerId().equals(bootstrap.getSession().getUserId()))
                System.out.println(n++ + ". " + task.toString());
        }
        System.out.print("Введите номер задачи для просмотра");
        int id = bootstrap.getNextInt();
        if (id > helperList.size()) return;
                else {
            String strId = helperList.get(id - 1).getUid();
            bootstrap.getTaskService().getTask(strId).toString();
        }

    }
}
