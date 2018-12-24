package org.alex.command;

import org.alex.controller.Bootstrap;

public class CreateTaskComand extends AbstractCommand{

    final public String description = "Create new Task";

    @Override
    public void execute(){

        System.out.println(description);
    }
}
