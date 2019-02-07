package org.alex.service;

import org.alex.api.service.IAssignmentService;
import org.alex.entity.Assignment;
import org.alex.repository.ProjectAssigneeAssgnmt;
import org.alex.repository.ProjectTaskAssgnmnt;
import org.alex.repository.TaskAssigneeAssgnmnt;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
@Transactional
public class AssignmentService implements IAssignmentService {

    @Inject
    private ProjectTaskAssgnmnt projectTask;
    @Inject
    private ProjectAssigneeAssgnmt projectAssignee;
    @Inject
    private TaskAssigneeAssgnmnt taskAssignee;

    public AssignmentService() throws FileNotFoundException {
    }

    @Override
    public void setConnection(@NotNull final Connection connection) {
        projectTask.setConnection(connection);
        projectAssignee.setConnection(connection);
        taskAssignee.setConnection(connection);
    }

    @Override
    public void assigneeToProject(@Nullable final Assignment assignment) throws SQLException {
        if (assignment == null) {
            return;
        } else {
            projectAssignee.add(assignment);
        }
    }

    @Override
    public void taskToProject(@Nullable Assignment assignment) throws SQLException {
        if (assignment == null) {
            return;
        } else {
            projectTask.add(assignment);
        }
    }

    @Override
    public void assigneeToTask(@Nullable final Assignment assignment) throws SQLException {
        if (assignment == null) {
            return;
        } else {
            taskAssignee.add(assignment);
        }
    }

    @Override
    public List<String> getAssigneeTasks(@Nullable final String assigneegId) {
        if (assigneegId.equals(null) || assigneegId.isEmpty()) return null;
        return taskAssignee.getAssignmentFromAssigned(assigneegId);
    }

    @Override
    public List<String> getProjectFromTask(@Nullable final String taskId) throws SQLException {
        if (taskId.isEmpty() || taskId.equals(null)) return null;
        return projectTask.getAssignmentFromAssigned(taskId);
    }

    @Override
    public List<String> getTasksFromProject(@Nullable final String projectId) {
        if (projectId.isEmpty() || projectId.equals(null)) return null;
        return projectTask.getAssignedFromAssignment(projectId);
    }

    @Override
    public List<String> getAssigneesFromTask(@Nullable final String taskId) {
        if (taskId.isEmpty() || taskId.equals(null)) return null;
        return taskAssignee.getAssignedFromAssignment(taskId);
    }

    @Override
    public List<String> getTasksFromAssignee(@Nullable final String assigneeId) {
        if (assigneeId.isEmpty() || assigneeId.equals(null)) return null;
        return taskAssignee.getAssignedFromAssignment(assigneeId);
    }

    @Override
    public List<String> getProjectFromAssignee(@Nullable final String assigneeId) throws SQLException {
        if (assigneeId.isEmpty() || assigneeId.equals(null)) return null;
        return projectAssignee.getAssignmentFromAssigned(assigneeId);
    }

    @Override
    public List<String> getAssigneesFromProject(@Nullable final String projectId) {
        if (projectId.isEmpty() || projectId.equals(null)) return null;
        return projectAssignee.getAssignedFromAssignment(projectId);
    }

    @Override
    public void mergeProjectAssigneesAssgnmnt(@NotNull final ProjectAssigneeAssgnmt assignment, @NotNull final List<Assignment> assignments) throws SQLException {
        assignment.merge(assignments);
    }

    @Override
    public void  mergeTaskAssigneesAssgnmnt(@NotNull TaskAssigneeAssgnmnt assignment, @NotNull List<Assignment> assignments) throws SQLException{
        assignment.merge(assignments);
    }

    @Override
    public void mergeProjectTasksAssgnmnt(@NotNull ProjectTaskAssgnmnt assignment, @NotNull List<Assignment> assignments) throws SQLException{
        assignment.merge(assignments);
    }


    @Override
    public void delProjectAssigneesAssgnmnt(@NotNull final Assignment assignment) throws SQLException {
        projectAssignee.delete(assignment);
    }

    @Override
    public void delTaskAssigneesAssgnmnt(@NotNull final Assignment assignment) throws SQLException {
        taskAssignee.delete(assignment);
    }

    @Override
    public void delProjectTasksAssgnmnt(@NotNull final Assignment assignment) throws SQLException {
        projectTask.delete(assignment);
    }

    @NotNull public List<Assignment> getAllProjAss() {
        return projectAssignee.getAll();
    }
    @NotNull public List<Assignment> getAllProjTsks() {
        return projectTask.getAll();
    }
    @NotNull public List<Assignment> getAllTsksAss() {
        return taskAssignee.getAll();
    }


    public void vacuum() {
//TODO: очистка дублей в таблицах. либо, возможно, не надо, если юник составной по двум полям???
    }

}
