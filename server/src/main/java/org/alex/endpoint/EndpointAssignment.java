package org.alex.endpoint;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignment;
import org.alex.repository.ProjectAssigneeAssgnmt;
import org.alex.repository.ProjectTaskAssgnmnt;
import org.alex.repository.TaskAssigneeAssgnmnt;
import org.alex.service.AssignmentService;
import org.jetbrains.annotations.NotNull;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.sql.SQLException;
import java.util.List;

@WebService
public class EndpointAssignment{

    private AssignmentService assignmentService;

    public EndpointAssignment() {
        Endpoint.publish("http://localhost:888/assignment", this);
    }

    public EndpointAssignment(@NotNull Bootstrap bootstrap) {
        Endpoint.publish("http://localhost:888/assignment?wsdl", this);
        assignmentService =  bootstrap.getAssignmentService();
    }

    @WebMethod
    public void assigneeToProject(@NotNull Assignment assignment) throws SQLException {
        assignmentService.assigneeToProject(assignment);
    }

    @WebMethod
    public void taskToProject(@NotNull Assignment assignment) throws SQLException {
        assignmentService.taskToProject(assignment);
    }

    @WebMethod
    public void assigneeToTask(@NotNull Assignment assignment) throws SQLException {
        assignmentService.assigneeToTask(assignment);
    }

    @WebMethod
    @NotNull public List<String> getAssigneeTasks(@NotNull String assigneegId) {
        return assignmentService.getAssigneeTasks(assigneegId);
    }

    @WebMethod
    @NotNull public List<String> getProjectFromTask(@NotNull String taskId) throws SQLException {
        return assignmentService.getProjectFromTask(taskId);
    }

    @WebMethod
    @NotNull public List<String> getTasksFromProject(@NotNull String projectId) {
        return assignmentService.getTasksFromProject(projectId);
    }

    @WebMethod
    @NotNull public List<String> getAssigneesFromTask(@NotNull String taskId) {
        return assignmentService.getAssigneesFromTask(taskId);
    }

    @WebMethod
    @NotNull public List<String> getTasksFromAssignee(@NotNull String assigneeId) {
        return assignmentService.getTasksFromAssignee(assigneeId);
    }

    @WebMethod
    @NotNull public List<String> getProjectFromAssignee(@NotNull String assigneeId) throws SQLException {
        return assignmentService.getProjectFromAssignee(assigneeId);
    }

    @WebMethod
    @NotNull public List<String> getAssigneesFromProject(@NotNull String projectId) {
        return assignmentService.getAssigneesFromProject(projectId);
    }

    @WebMethod
    public void mergeTaskAssignees(@NotNull List<Assignment> assignments) throws SQLException {
        assignmentService.mergeTaskAssigneesAssgnmnt(new TaskAssigneeAssgnmnt(), assignments);
    }

    @WebMethod
    public void mergeProjectAssignees(@NotNull List<Assignment> assignments) throws SQLException {
        assignmentService.mergeProjectAssigneesAssgnmnt(new ProjectAssigneeAssgnmt(), assignments);
    }

    @WebMethod
    public void mergeProjectTasks(@NotNull List<Assignment> assignments) throws SQLException {
        assignmentService.mergeProjectTasksAssgnmnt(new ProjectTaskAssgnmnt(), assignments);
    }

    // FIXME: 28.01.19
//    @WebMethod
//    public void delAssignment(@NotNull IAssignment silo, @NotNull Assignment assignment) throws IllegalStringException, SQLException {
//        assignmentService.delAssignment(silo, assignment);
//    }

    @WebMethod
    public void vacuum() {
        assignmentService.vacuum();
    }

}
