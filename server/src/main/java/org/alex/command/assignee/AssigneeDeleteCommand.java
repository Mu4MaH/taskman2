package org.alex.command.assignee;

import org.alex.controller.Bootstrap;
import org.alex.exception.IllegalStringException;
import org.alex.command.AbstractCommand;
import org.alex.entity.Assignee;

import java.util.ArrayList;
import java.util.List;

public class AssigneeDeleteCommand extends AbstractCommand {

    final private String command = "ad";
    final private String description = "Удалить учётную запись исполнителя.";

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute(Bootstrap bootstrap) throws IllegalStringException {
        if (bootstrap.getAssigneeService().getAssigneeAdminGroup().contains(bootstrap.getLoggedAssigneeId())) { //порверка на вхождение удаляющего в админы
            int i = 0;
            final List<Assignee> helperList = new ArrayList<>(bootstrap.getAssigneeService().getAllAssignee());
            for (i = 0; i < helperList.size(); i++) {
                System.out.println((i + 1) + ". " + helperList.get(i).toString());
            }

            System.out.print("Выберите номер удаляемого пользователя: ");
            final int id = bootstrap.getNextInt();
            final String helperString = helperList.get(id-1).getUid();
            bootstrap.getAssigneeService().deleteAssignee(helperString);
        } else System.out.println("Недостаточно прав на удаление.");
    }

}
