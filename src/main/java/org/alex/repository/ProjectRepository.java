package org.alex.repository;

import org.alex.api.repository.IProjectRepository;
import org.alex.entity.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRepository implements IProjectRepository {

    private final Map<String, Project> projects = new HashMap<>();

    public void addProject(final Project project) {
        this.projects.put(project.getUid(), project);
    }

    public Project getProject(final String uid) {
        return this.projects.get(uid);
    }

    public List<Project> getAllProjects() {
        return new ArrayList<>(this.projects.values());
    }

    public void mergeProjects(List<Project> list) {
        for (Project project : list) {
            this.projects.put(project.getUid(), project);
        }
    }

}


