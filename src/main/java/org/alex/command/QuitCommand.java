package org.alex.command;

import org.alex.App;

public class QuitCommand extends AbstractCommand{
    public final String command = "quit";
    @Override
    public void execute() {
        System.exit(0);
    }

}
