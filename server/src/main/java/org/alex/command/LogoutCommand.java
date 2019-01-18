package org.alex.command;

import org.alex.controller.Bootstrap;

public class LogoutCommand extends AbstractCommand {

    final public String description = "Завершение сессии пользователя.";
    final public String command = "logout";

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
        bootstrap.logout();
    }

}
