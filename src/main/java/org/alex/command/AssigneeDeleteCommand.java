package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;

import java.util.ArrayList;
import java.util.List;

public class AssigneeDeleteCommand extends AbstractCommand {

    final private String command = "ad";
    final private String description = "Erases assignee everywhere..";

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute(Bootstrap bootstrap) { //воркеров в мапу инкремент|воркер можно просить у юзверя ввод числа а не хекс айди
        int id = 1;
        final List<Assignee> helperList = new ArrayList<>(bootstrap.getAssigneeService().getAllAssignee());
        for (Assignee assignee : helperList) {
            System.out.println(assignee.toString());
        }

        System.out.print("Enter uid of worker to delete: ");
        final String strHelper = bootstrap.getString();
        bootstrap.getAssigneeService().deleteAssignee(strHelper);
    }

}
