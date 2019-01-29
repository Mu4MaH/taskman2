package org.alex.api.service;

import org.alex.entity.Project;
import org.alex.exception.IllegalArgumentException;
import org.alex.exception.IllegalStringException;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public interface IProjectService {

    void createProject(Project project);

    void setSessionFactory(SqlSessionFactory sqlSessionFactory);

    Project getProject(String uid) throws IllegalStringException, IllegalArgumentException;

    List<Project> getAllProject();

    void mergeProject(List<Project> projects);

    void deleteProject(String uid);

}
