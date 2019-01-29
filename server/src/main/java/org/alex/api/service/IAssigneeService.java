package org.alex.api.service;

import org.alex.entity.Assignee;
import org.alex.exception.IllegalStringException;

import java.sql.Connection;
import java.util.List;

public interface IAssigneeService {

    Assignee getAssignee(String uid) throws IllegalStringException;

    void deleteAssignee(String uid) throws IllegalStringException;

    void createAssignee(Assignee assignee);

    List<Assignee> getAllAssignee();

    String getAssigneeAdminGroup();

    void mergeAssignee(List<Assignee> assignees);

    Assignee getAssigneeByLogin(String login);

    void setConnection (Connection connection);
}
