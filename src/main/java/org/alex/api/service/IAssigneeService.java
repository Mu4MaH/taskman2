package org.alex.api.service;

import org.alex.entity.Assignee;

import java.util.List;

public interface IAssigneeService {

    Assignee getAssigneeByUid(String uid);

    void deleteAssignee(String uid);

    void addAssignee(Assignee assignee);

    List<Assignee> getAllAssignee();

}
