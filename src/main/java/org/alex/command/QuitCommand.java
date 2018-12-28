package org.alex.command;

import org.alex.controller.Bootstrap;

public class QuitCommand extends AbstractCommand {
    private final String command = "quit";

    @Override
    public void execute(Bootstrap bootstrap) {
        System.exit(0);
    }

    public String getCommand() {
        return this.command;
    }

}
