package org.alex.command;

public class GetTaskCommand extends AbstractCommand{

    final public String description = "List of tasks";

    @Override
    public void execute(){
        System.out.println(description);
    }
}
