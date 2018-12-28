package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;

import java.io.File;

public class AssigneeFlushToDiskCommand extends AbstractCommand {

    final private String command = "assignee-flush";
    final private String description = "Flushes assignees data to disk";

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
        Assignee[] toFlush = bootstrap.assigneeService.getAllAssignee().toArray(new Assignee[0]);
        final String filename = "./data.tm";
        if (bootstrap.assigneeFlushDataService.flush(new File(filename))) System.out.println("Success.");
        else System.out.println("Error");
    }

}
