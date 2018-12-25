package org.alex.repository;

import org.alex.entity.Project;

import java.util.Map;
import java.util.UUID;

public class ProjectRepository {

    private Map<String, Project> projects;
    private Project project = new Project();

    public void addProject(Project project) {
        projects.put(project.getUid(), project);
    }

    public void addProject(){

    }

    public void removeProject(String uid) {
        projects.remove(uid);
    }

    public void removeProject(Project project) {
        projects.remove(project.getUid());
    }

    public Project getProjectByUid(String uid) {
        return projects.get(uid);
    }

}


