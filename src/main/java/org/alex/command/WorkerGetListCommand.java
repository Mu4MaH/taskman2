package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.repository.WorkerRepository;

public class WorkerGetListCommand extends AbstractCommand{

    private final String command = "workers-list";
    private final String description = "Command to get list of workers";

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        int id = 1;
        System.out.println(description);
        final WorkerRepository helperRepo = bootstrap.workerService.getRepo();
        for (String key: helperRepo.getRepo().keySet()) {
            System.out.println(id++ +". " + helperRepo.getRepo().get(key));
        }
    }

}
