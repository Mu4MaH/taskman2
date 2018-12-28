package org.alex.service;

import org.alex.api.service.IProjectService;
import org.alex.entity.Project;
import org.alex.repository.ProjectRepository;

import java.util.List;

public class ProjectService implements IProjectService {

    ProjectRepository projectRepository = new ProjectRepository();

    public ProjectRepository getRepo() {
        return this.projectRepository;
    }

    public void addProject(Project project) {
        projectRepository.addProject(project);
    }

    public Project getProject(String uid) {
        return projectRepository.getProject(uid);
    }

    public void updateProject(Project project) {
        projectRepository.updateProject(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.getAllProjects();
    }

}
