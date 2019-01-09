package org.alex.api.service;

import org.alex.entity.Assignee;
import org.alex.exception.IllegalStringException;

import java.util.List;

public interface IAssigneeService {

    Assignee getAssigneeByUid(String uid) throws IllegalStringException;

    void deleteAssignee(String uid) throws IllegalStringException;

    void addAssignee(Assignee assignee);

    List<Assignee> getAllAssignee();

}
