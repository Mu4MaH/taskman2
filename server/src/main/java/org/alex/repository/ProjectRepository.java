package org.alex.repository;

import org.alex.api.repository.IProjectRepository;
import org.alex.entity.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRepository implements IProjectRepository {

    private final Map<String, Project> projects = new HashMap<>();

    @Override
    public void add(final Project project) {
        this.projects.put(project.getUid(), project);
    }

    @Override
    public IProjectRepository get(final String uid) {
        return (IProjectRepository) this.projects.get(uid);
    }

    @Override
    public List<Project> getAll() {
        return new ArrayList<>(this.projects.values());
    }

    @Override
    public void merge(final List<Project> list) {
        for (Project project : list) {
            this.projects.put(project.getUid(), project);
        }
    }

}


