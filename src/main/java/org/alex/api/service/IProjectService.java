package org.alex.api.service;

import org.alex.entity.Project;
import org.alex.repository.ProjectRepository;

import java.util.List;

public interface IProjectService {

    public ProjectRepository getRepo();
    public void addProject(Project project);

    public Project getProject(String uid);

    public void updateProject(Project project);

    public List<Project> getAllProjects();

}
