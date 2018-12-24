package org.alex.command;

public class HelpCommand extends AbstractCommand{

    final String description="Help topic";

    @Override
    public void execute() {
        System.out.println(description);
    }
}
