package org.alex.api.repository;

import org.alex.entity.Project;

import java.util.List;

public interface IProjectRepository {

    void add(Project project);

    IProjectRepository get(String uid);

    List<Project> getAll();

    void merge(List<Project> list);

}
