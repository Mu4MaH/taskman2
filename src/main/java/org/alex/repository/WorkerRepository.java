package org.alex.repository;

import org.alex.entity.Worker;

import java.util.HashMap;
import java.util.Map;

public class WorkerRepository {
    private final Map<String, Worker> stuff = new HashMap<>();

    public void addWorker(Worker worker){
        stuff.put(worker.getUid(),worker);
    }

    public Worker getWorkerByUid (String uid){ return stuff.get(uid);}

}
