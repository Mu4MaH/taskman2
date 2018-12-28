package org.alex.api.repository;

import org.alex.entity.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IProjectRepository {

    public void addProject(Project project);

    public Project getProject(String uid);

    public void updateProject(Project project);

    public List<Project> getAllProjects ();
}
