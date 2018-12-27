package org.alex.service;

import org.alex.repository.ProjectRepository;

public class ProjectService {

     ProjectRepository projectRepository = new ProjectRepository();

     public ProjectRepository getRepo(){
          return this.projectRepository;
     }


     /*делегирование го!*/

}
