package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;
import org.alex.error.WorkerNameException;

public class AssigneeCreateCommand extends AbstractCommand {

    final private String command = "worker-create";

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        System.out.print("Введите имя работника: ");
        final String strHelper = bootstrap.getString();
        if (strHelper == "Mahmud") try {
            throw new WorkerNameException();
        } catch (WorkerNameException e) {
            e.printStackTrace();
            System.out.println("Исполнителей с именем Mahmud не должно быть.");
        }
        bootstrap.assigneeService.addAssignee(new Assignee(strHelper));
    }

}

