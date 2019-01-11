package org.alex.service;

import org.alex.api.service.IProjectService;
import org.alex.entity.Project;
import org.alex.exception.IllegalStringException;
import org.alex.repository.ProjectRepository;

import java.util.List;

public class ProjectService implements IProjectService {

    ProjectRepository projectRepository = new ProjectRepository();

    /* +++ Отладочные записи +++ */
    {

        projectRepository.addProject(new Project("proj1"));
        projectRepository.addProject(new Project("proj2"));
        projectRepository.addProject(new Project("proj3"));

    }
    /*      ***      */

    @Override
    public void addProject(Project project) {
        if (project == null) return;
        this.projectRepository.addProject(project);
    }

    @Override
    public Project getProject(String uid) throws IllegalStringException {
        if (uid.isEmpty() || uid.equals(null)) {
            throw new IllegalStringException();
        } else {
            return this.projectRepository.getProject(uid);
        }
    }

    @Override
    public List<Project> getAllProjects() {
        return this.projectRepository.getAllProjects();
    }

    @Override
    public void mergeProjects(List<Project> list) {
        if (list.equals(null)) return;
        this.projectRepository.mergeProjects(list);
    }
}


