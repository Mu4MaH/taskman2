package org.alex.service;

import org.alex.api.service.IProjectService;
import org.alex.entity.Project;
import org.alex.repository.ProjectRepository;

import java.util.List;

public class ProjectService implements IProjectService {

    ProjectRepository projectRepository = new ProjectRepository();

    public void addProject(Project project) {
        this.projectRepository.addProject(project);
    }

    public Project getProject(String uid) {
        return this.projectRepository.getProject(uid);
    }

    public List<Project> getAllProjects() {
        return this.projectRepository.getAllProjects();
    }

    @Override
    public void mergeProjects(List<Project> list) {
        this.projectRepository.mergeProjects(list);
    }

}
