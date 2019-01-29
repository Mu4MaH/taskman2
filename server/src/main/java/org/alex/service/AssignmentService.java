package org.alex.service;

import org.alex.api.service.IAssignment;
import org.alex.api.service.IAssignmentService;
import org.alex.entity.Assignment;
import org.alex.exception.IllegalStringException;
import org.alex.repository.ProjectAssigneeAssgnmt;
import org.alex.repository.ProjectTaskAssgnmnt;
import org.alex.repository.TaskAssigneeAssgnmnt;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AssignmentService implements IAssignmentService {

    final private ProjectTaskAssgnmnt projectTask = new ProjectTaskAssgnmnt();
    final private ProjectAssigneeAssgnmt projectAssignee = new ProjectAssigneeAssgnmt();
    final private TaskAssigneeAssgnmnt taskAssignee = new TaskAssigneeAssgnmnt();

    public AssignmentService() throws FileNotFoundException {
    }

    @Override
    public void setConnection(@NotNull final Connection connection) {
        projectTask.setConnection(connection);
        projectAssignee.setConnection(connection);
        taskAssignee.setConnection(connection);
    }

    @Override
    public void assigneeToProject(@NotNull final Assignment assignment) throws SQLException {
        if (assignment == null) {
            return;
        } else {
            projectAssignee.add(assignment);
        }
    }

    @Override
    public void taskToProject(@NotNull Assignment assignment) throws SQLException {
        if (assignment == null) {
            return;
        } else {
            projectTask.add(assignment);
        }
    }

    @Override
    public void assigneeToTask(@NotNull final Assignment assignment) throws SQLException {
        if (assignment == null) {
            return;
        } else {
            taskAssignee.add(assignment);
        }
    }

    @Override
    public List<String> getAssigneeTasks(@NotNull final String assigneegId) {
        if (assigneegId.equals(null) || assigneegId.isEmpty()) return null;
        return taskAssignee.getAssignmentFromAssigned(assigneegId);
    }

    @Override
    public List<String> getProjectFromTask(@NotNull final String taskId) throws SQLException {
        if (taskId.isEmpty() || taskId.equals(null)) return null;
        return projectTask.getAssignmentFromAssigned(taskId);
    }

    @Override
    public List<String> getTasksFromProject(@NotNull final String projectId) {
        if (projectId.isEmpty() || projectId.equals(null)) return null;
        return projectTask.getAssignedFromAssignment(projectId);
    }

    @Override
    public List<String> getAssigneesFromTask(@NotNull final String taskId) {
        if (taskId.isEmpty() || taskId.equals(null)) return null;
        return taskAssignee.getAssignedFromAssignment(taskId);
    }

    @Override
    public List<String> getTasksFromAssignee(@NotNull final String assigneeId) {
        if (assigneeId.isEmpty() || assigneeId.equals(null)) return null;
        return taskAssignee.getAssignedFromAssignment(assigneeId);
    }

    @Override
    public List<String> getProjectFromAssignee(@NotNull final String assigneeId) throws SQLException {
        if (assigneeId.isEmpty() || assigneeId.equals(null)) return null;
        return projectAssignee.getAssignmentFromAssigned(assigneeId);
    }

    @Override
    public List<String> getAssigneesFromProject(@NotNull final String projectId) {
        if (projectId.isEmpty() || projectId.equals(null)) return null;
        return projectAssignee.getAssignedFromAssignment(projectId);
    }

    @Override
    public void mergeProjectAssigneesAssgnmnt(@NotNull final ProjectAssigneeAssgnmt assignment, @NotNull final List<Assignment> assignments) throws SQLException {
        assignment.merge(assignments);
    }

    @Override
    public void  mergeTaskAssigneesAssgnmnt(TaskAssigneeAssgnmnt assignment, List<Assignment> assignments) throws SQLException{
        assignment.merge(assignments);
    }

    @Override
    public void mergeProjectTasksAssgnmnt(ProjectTaskAssgnmnt assignment, List<Assignment> assignments) throws SQLException{
        assignment.merge(assignments);
    }


    @Override
    public void delAssignment(@NotNull final IAssignment silo, @NotNull final Assignment assignment) throws IllegalStringException, SQLException {
        silo.delete(assignment);
    }

    public List<Assignment> getAllProjAss() {
        return projectAssignee.getAll();
    }

    public List<Assignment> getAllProjTsks() {
        return projectTask.getAll();
    }
    public List<Assignment> getAllTsksAss() {
        return taskAssignee.getAll();
    }


    public void vacuum() {
//TODO: очистка дублей в таблицах. либо, возможно, не надо, если юник составной по двум полям???
    }

}
