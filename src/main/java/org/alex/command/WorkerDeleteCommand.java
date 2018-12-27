package org.alex.command;

import org.alex.controller.Bootstrap;
import org.alex.entity.Worker;
import org.alex.repository.WorkerRepository;

public class WorkerDeleteCommand extends AbstractCommand {
    final private String command = "worker-del";
    final private String description ="Erases worker everywhere..";

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public void execute(Bootstrap bootstrap) { //воркеров в мапу инкремент|воркер можно просить у юзверя ввод числа а не хекс айди
        System.out.print("Enter uid of worker to delete: ");
        final String strHelper = bootstrap.getString();
        final Worker workerHelper = new Worker(strHelper);
        final WorkerRepository helperRepo = bootstrap.workerService.getRepo();
        helperRepo.deleteWorker(strHelper);
    }
}
