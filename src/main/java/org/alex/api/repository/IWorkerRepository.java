package org.alex.api.repository;

import org.alex.entity.Assignee;

import java.util.List;

public interface IWorkerRepository {

    public void addWorker(Assignee assignee);

    public Assignee getWorkerByUid(String uid);

    public void deleteWorker(String uid);

    public List<Assignee> getAllWorkers();

}
