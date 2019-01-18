package org.alex.api.service;

import org.alex.entity.Assignee;
import org.alex.exception.IllegalStringException;

import java.util.List;

public interface IAssigneeService {

    Assignee get(String uid) throws IllegalStringException;

    void delete(String uid) throws IllegalStringException;

    void create(Assignee assignee);

    List<Assignee> getAll();

    String getAdminGroup();

    void merge(List<Assignee> assignees);
}
