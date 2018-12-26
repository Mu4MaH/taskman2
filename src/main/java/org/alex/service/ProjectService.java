package org.alex.service;

import org.alex.repository.ProjectRepository;
import org.alex.service.TaskService;

public class ProjectService {

     private final ProjectRepository projects = new ProjectRepository();

     public ProjectRepository getRepo(){
          return this.projects;
     }

}
