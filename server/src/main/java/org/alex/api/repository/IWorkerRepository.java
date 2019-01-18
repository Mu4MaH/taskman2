package org.alex.api.repository;

import org.alex.entity.Assignee;

import java.util.List;

public interface IWorkerRepository {

    public void add(Assignee assignee);

    public Assignee get(String uid);

    public void delete(String uid);

    public List<Assignee> getAll();

}
