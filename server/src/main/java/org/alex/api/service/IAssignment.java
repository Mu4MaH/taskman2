package org.alex.api.service;

import org.alex.entity.Assignment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IAssignment {

    void setConnection(Connection connection);

    void add(Assignment assignment) throws SQLException;

    void delete(Assignment assignment) throws SQLException;

    List<String> getAssignedFromAssignment(String assignmentId);

    List<String> getAssignmentFromAssigned (String assignedId) throws SQLException;

    void merge(List<Assignment> assignments) throws SQLException;

    List<Assignment> getAll();

}
