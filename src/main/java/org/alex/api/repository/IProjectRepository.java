package org.alex.api.repository;

import org.alex.entity.Project;

import java.util.List;

public interface IProjectRepository {

    void addProject(Project project);

    Project getProject(String uid);

    List<Project> getAllProjects();

    void mergeProjects(List<Project> list);

}
