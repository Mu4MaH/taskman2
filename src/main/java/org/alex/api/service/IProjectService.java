package org.alex.api.service;

import org.alex.entity.Project;
import org.alex.exception.IllegalStringException;

import java.util.List;

public interface IProjectService {

    void addProject(Project project);

    Project getProject(String uid) throws IllegalStringException;

    List<Project> getAllProjects();

    void mergeProjects(List<Project> projects);

}
