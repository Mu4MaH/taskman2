package org.alex.command;

import org.alex.entity.Project;

public class CreateProjectCommand extends AbstractCommand {

    public final String description = "Create new project";

    @Override
    public void execute(){
        System.out.println(description);
    }
}
