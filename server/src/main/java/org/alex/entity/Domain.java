package org.alex.entity;

import org.alex.controller.Bootstrap;
import org.alex.repository.ProjectAssigneeAssgnmt;
import org.alex.repository.ProjectTaskAssgnmnt;
import org.alex.repository.TaskAssigneeAssgnmnt;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class Domain implements Serializable {
    private List<Project> projects;
    private List<Task> tasks;
    private List<Assignee> assignees;
    private List<Assignment> projectAssignees;
    private List<Assignment> taskAssignees;
    private List<Assignment> projectTasks;

    public void setProjectAssignees(@NotNull List<Assignment> projectAssignees) {
        this.projectAssignees = projectAssignees;
    }

    public List<Assignment> getTaskAssignees() {
        return taskAssignees;
    }

    public boolean setTaskAssignees(@NotNull List<Assignment> taskAssignees) {
        if (taskAssignees == null) return false;
        this.taskAssignees = taskAssignees;
        return true;
    }

    public List<Assignment> getProjectTasks() {
        return projectTasks;
    }

//    public void setProjectTasks(@NotNull List<Assignment> projectTasks) {
//        this.projectTasks = projectTasks;
//    }

    public Domain createDomain(@NotNull Bootstrap bootstrap) {
        final List<Project> projects = bootstrap.getProjectService().getAllProject();
        final List<Task> tasks = bootstrap.getTaskService().getAllTask();
        final List<Assignee> assignees = bootstrap.getAssigneeService().getAllAssignee();
        final List<Assignment> projectAssignees = bootstrap.getAssignmentService().getAllProjAss();
        final List<Assignment> projectTasks = bootstrap.getAssignmentService().getAllProjTsks();
        final List<Assignment> taskAssignes = bootstrap.getAssignmentService().getAllTsksAss();
        Domain domain = new Domain();
        if (domain.setProjects(projects))
            if (domain.setTasks(tasks))
                if (domain.setAssignees(assignees))
                    if (domain.setProjectAssigneesAssgnmnts(projectAssignees))
                        if (domain.setTaskAssignees(taskAssignees))
                            if (domain.setProjectTasksAssgnmnts(projectTasks)) return domain;
        return null;
    }

    public void loadDomain(@NotNull Bootstrap bootstrap, @NotNull Domain domain) throws SQLException {
        final List<Project> projects = domain.getProjects();
        final List<Task> tasks = domain.getTasks();
        final List<Assignee> assignees = domain.getAssignees();
        final List<Assignment> projectAssignees = domain.getProjectAssignees();
        final List<Assignment> projectTasks = domain.getProjectTasks();
        final List<Assignment> taskAssignees = domain.getTaskAssignees();
        bootstrap.getProjectService().mergeProject(projects);
        bootstrap.getTaskService().mergeTasks(tasks);
        bootstrap.getAssigneeService().mergeAssignee(assignees);
        bootstrap.getAssignmentService().mergeProjectAssigneesAssgnmnt(new ProjectAssigneeAssgnmt(), projectAssignees);
        bootstrap.getAssignmentService().mergeProjectTasksAssgnmnt(new ProjectTaskAssgnmnt(), projectTasks);
        bootstrap.getAssignmentService().mergeTaskAssigneesAssgnmnt(new TaskAssigneeAssgnmnt(), taskAssignees);


    }

    public List<Project> getProjects() {
        return projects;
    }

    public boolean setProjects(@NotNull List<Project> projects) {
        if (projects == null) return false;
        this.projects = projects;
        return true;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public boolean setTasks(@NotNull List<Task> tasks) {
        if (tasks == null) return false;
        this.tasks = tasks;
        return true;
    }

    public List<Assignee> getAssignees() {
        return assignees;
    }

    public boolean setAssignees(@NotNull List<Assignee> assignees) {
        if (assignees == null) return false;
        this.assignees = assignees;
        return true;
    }

    public List<Assignment> getProjectAssignees() {
        return projectAssignees;
    }

    public boolean setProjectAssigneesAssgnmnts(@NotNull List<Assignment> assignments) {
        if (assignments == null) return false;
        this.projectAssignees = assignments;
        return true;
    }

    public boolean settaskAssigneesAssgnmnts(@NotNull List<Assignment> assignments) {
        if (assignments == null) return false;
        this.taskAssignees = assignments;
        return true;
    }

    public boolean setProjectTasksAssgnmnts(@NotNull List<Assignment> assignments) {
        if (assignments == null) return false;
        this.projectTasks = assignments;
        return true;
    }


}
