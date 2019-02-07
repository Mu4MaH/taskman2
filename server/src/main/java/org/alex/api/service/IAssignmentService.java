package org.alex.api.service;

import org.alex.entity.Assignment;
import org.alex.repository.ProjectAssigneeAssgnmt;
import org.alex.repository.ProjectTaskAssgnmnt;
import org.alex.repository.TaskAssigneeAssgnmnt;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IAssignmentService {
    void setConnection(Connection connection);

    void assigneeToProject(Assignment assignment) throws SQLException;

    void taskToProject(Assignment assignment) throws SQLException;

    void assigneeToTask(Assignment assignment) throws SQLException;

    List<String> getAssigneeTasks(String assigneegId);

    List<String> getProjectFromTask(String taskId) throws SQLException;

    List<String> getTasksFromProject(String projectId);

    List<String> getAssigneesFromTask(String taskId);

    List<String> getTasksFromAssignee(String assigneeId);

    List<String> getProjectFromAssignee(String assigneeId) throws SQLException;

    List<String> getAssigneesFromProject(String projectId);

    void  mergeTaskAssigneesAssgnmnt(TaskAssigneeAssgnmnt assignment, List<Assignment> assignments) throws SQLException;

    void mergeProjectAssigneesAssgnmnt (ProjectAssigneeAssgnmt assignment, List<Assignment> assignments) throws SQLException;

    void mergeProjectTasksAssgnmnt (ProjectTaskAssgnmnt assignment, List<Assignment> assignments) throws SQLException;

    void delProjectAssigneesAssgnmnt(Assignment assignment) throws SQLException;

    void delTaskAssigneesAssgnmnt(Assignment assignment) throws SQLException;

    void delProjectTasksAssgnmnt(Assignment assignment) throws SQLException;
}
