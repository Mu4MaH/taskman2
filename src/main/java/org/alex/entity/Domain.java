package org.alex.entity;

import org.alex.controller.Bootstrap;

import java.io.Serializable;
import java.util.List;

public class Domain implements Serializable {
    private List<Project> projects;
    private List<Task> tasks;
    private List<Assignee> assignees;
    private List<Assignment> assignments;

    public Domain createDomain(Bootstrap bootstrap) {
        final List<Project> projects = bootstrap.getProjectService().getAllProjects();
        final List<Task> tasks = bootstrap.getTaskService().getAllTasks();
        final List<Assignee> assignees = bootstrap.getAssigneeService().getAllAssignee();
        final List<Assignment> assignments = bootstrap.getAssignmentService().getAllAssignments();
        Domain domain = new Domain();
        if (domain.setProjects(projects))
            if (domain.setTasks(tasks))
                if (domain.setAssignees(assignees))
                    if (domain.setAssignments(assignments)) return domain;
        return null;
    }

    public void loadDomain(Bootstrap bootstrap, Domain domain){
        final List<Project> projects = domain.getProjects();
        final List<Task> tasks = domain.getTasks();
        final List<Assignee> assignees = domain.getAssignees();
        final List<Assignment> assignments = domain.getAssignments();
        bootstrap.getProjectService().mergeProjects(projects);
        bootstrap.getTaskService().mergeTasks(tasks);
        bootstrap.getAssigneeService().mergeAssignee(assignees);
        bootstrap.getAssignmentService().mergeAssignments(assignments);

    }

    public List<Project> getProjects() {
        return projects;
    }

    public boolean setProjects(List<Project> projects) {
        if (projects == null) return false;
        this.projects = projects;
        return true;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public boolean setTasks(List<Task> tasks) {
        if (tasks == null) return false;
        this.tasks = tasks;
        return true;
    }

    public List<Assignee> getAssignees() {
        return assignees;
    }

    public boolean setAssignees(List<Assignee> assignees) {
        if (assignees == null) return false;
        this.assignees = assignees;
        return true;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public boolean setAssignments(List<Assignment> assignments) {
        if (assignments == null) return false;
        this.assignments = assignments;
        return true;
    }
}
