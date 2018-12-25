package org.alex.service;

import org.alex.entity.Project;
import org.alex.entity.Task;
import org.alex.repository.ProjectRepository;
import org.alex.repository.TaskRepository;

public class Service {

 private ProjectRepository projects = new ProjectRepository();
 private TaskRepository taskRepository = new TaskRepository();

 public ProjectRepository getProjects() {
  return projects;
 }

 public void addProject(ProjectRepository projects) {
  this.projects = projects;
 }

 public TaskRepository getTaskRepository() {
  return taskRepository;
 }

 public void setTaskRepository(TaskRepository taskRepository) {
  this.taskRepository = taskRepository;
 }
}
