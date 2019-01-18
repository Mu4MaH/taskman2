package org.alex.api.service;

import org.alex.entity.Project;
import org.alex.exception.IllegalArgumentException;
import org.alex.exception.IllegalStringException;

import java.util.List;

public interface IProjectService {

    void create(Project project);

    Project get(String uid) throws IllegalStringException, IllegalArgumentException;

    List<Project> getAll();

    void merge(List<Project> projects);

}
