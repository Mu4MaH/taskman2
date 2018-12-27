package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Worker;
import org.alex.repository.WorkerRepository;

public class WorkerNewCommand extends AbstractCommand{

    final private String command = "worker-create";

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public void execute(Bootstrap bootstrap) {
        final WorkerRepository helperRepo = bootstrap.workerService.getRepo();
        System.out.print("Введите имя работника: ");
        final Worker workerHelper = new Worker(bootstrap.getString());
        helperRepo.addWorker(workerHelper);
        final String uid = workerHelper.getUid();
    }

}

