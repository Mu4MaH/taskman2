package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Task;
import org.alex.repository.TaskRepository;

public class TaskDeleteCommand extends AbstractCommand {
    final public String description = "Remove task from list by i";
    final public String command = "del-task";

    public String getCommand() {
        return command;
    }

    @Override
    public void execute(Bootstrap bootstrap){
        System.out.print("Enter uid of task to delete: ");
        final String strHelper = bootstrap.getString();
        final Task taskHelper = new Task(strHelper);
        final TaskRepository helperRepo = bootstrap.taskService.getRepo();
        helperRepo.deleteTask(strHelper);
    }

}
