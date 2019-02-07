package org.alex.api.service;

import org.alex.entity.Project;
import org.alex.exception.IllegalStringException;
import org.alex.exception.WrongArgumentTypeException;

import java.util.List;

public interface IProjectService {

    void createProject(Project project);

    Project getProject(String uid) throws IllegalStringException, WrongArgumentTypeException;

    List<Project> getAllProject();

    void mergeProject(List<Project> projects);

    void deleteProject(String uid);

}
