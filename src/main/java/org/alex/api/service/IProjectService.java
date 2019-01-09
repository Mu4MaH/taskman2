package org.alex.api.service;

import org.alex.entity.Project;
import org.alex.repository.ProjectRepository;

import java.util.List;

public interface IProjectService {

    void addProject(Project project);

    Project getProject(String uid);

    List<Project> getAllProjects();

    void mergeProjects(List<Project> projects);

}
