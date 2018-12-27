package org.alex.service;

import org.alex.repository.WorkerRepository;

public class WorkerService {
    private final WorkerRepository stuff = new WorkerRepository();

    public WorkerRepository getRepo() {
        return this.stuff;
    }
}
