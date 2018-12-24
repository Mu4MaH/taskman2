package org.alex.command;

public final class GetProjectCommand extends AbstractCommand{

    final public String description = "Get Project List";

    @Override
    public void execute() {
        System.out.println(description);
    }
}
