package org.alex.repository;

import org.alex.entity.Project;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProjectRepository {

    private final Map<String, Project> projects = new HashMap<>();

    public void addProject(Project project) {
        projects.put(project.getUid(), project);
    }

    public void addProject(){
        projects.put(String.valueOf(UUID.randomUUID()), new Project());
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

    public HashMap<String, Project> getAllTasks () {
        Map<java.lang.String, Project> output = new HashMap<>();
        if (projects.isEmpty()) return (HashMap<java.lang.String, Project>) output;
        else {
            int id = 0;
            for (java.lang.String key : projects.keySet())
                output.put(key,projects.get(key));
        }
        return (HashMap<java.lang.String, Project>) output;
    }

}


