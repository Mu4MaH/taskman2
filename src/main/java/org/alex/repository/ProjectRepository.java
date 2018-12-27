package org.alex.repository;

import org.alex.entity.Project;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProjectRepository {

    private final Map<String, Project> projects = new HashMap<>();

    public Map<String, Project> getRepo(){
        return this.projects;
    }

    public void addProject(Project project){
        projects.put(project.getUid(),project);
    }

    public Project getProject(String uid) {
        return projects.get(uid);
    }

    public Map<String,Project> getProjects() {
        return projects;
    }

    public void updateProject(Project project) {
        projects.put(project.getUid(),project);
    }

}


