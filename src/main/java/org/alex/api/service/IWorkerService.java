package org.alex.api.service;

import org.alex.entity.Assignee;

import java.util.List;

public interface IWorkerService {

    public Assignee getAssigneeByUid(String uid);

    public void deleteAssignee(String uid);

    public void addAssignee(Assignee assignee);

    public List<Assignee> getAllAssignee();

}
