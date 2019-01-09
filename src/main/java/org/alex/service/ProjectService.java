package org.alex.service;

import org.alex.api.service.IProjectService;
import org.alex.entity.Project;
import org.alex.exception.IllegalStringException;
import org.alex.repository.ProjectRepository;

import java.util.List;

public class ProjectService implements IProjectService {

    ProjectRepository projectRepository = new ProjectRepository();

    public void addProject(Project project) {
        if (project != null) {
            this.projectRepository.addProject(project);
        } else {
            throw new NullPointerException();
        }
    }

    public Project getProject(String uid) throws IllegalStringException {
        if (uid != "" && uid != null) {
            return this.projectRepository.getProject(uid);
        } else {
            throw new IllegalStringException();
        }
    }

    public List<Project> getAllProjects() {
        return this.projectRepository.getAllProjects();
    }

    @Override
    public void mergeProjects(List<Project> list) {
        if (list != null) {
            this.projectRepository.mergeProjects(list);
        } else {
            throw new NullPointerException();
        }
    }
}


