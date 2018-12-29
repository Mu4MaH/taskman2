package org.alex.repository;

import org.alex.api.repository.IProjectRepository;
import org.alex.entity.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRepository implements IProjectRepository {

    private final Map<String, Project> projects = new HashMap<>();

    public void addProject(Project project) {
        projects.put(project.getUid(), project);
    }

    public Project getProject(String uid) {
        return projects.get(uid);
    }

    public void updateProject(Project project) {
        projects.put(project.getUid(), project);
    }

    public List<Project> getAllProjects() {
        return new ArrayList<>(projects.values());
    }

    public void mergeProjects(List<Project> list) {

        for (Project project: list)
        {projects.put(project.getUid(),project);
        }
    }

}


