package org.alex.service;

import org.alex.entity.Task;
import org.alex.repository.TaskRepository;

public class TaskService {

    private final TaskRepository taskRepository = new TaskRepository();

    public TaskRepository getRepo() {
       return this.taskRepository;
   }

    /*делегирование го!*/

    public void serviceDeleteTask(String uid) {
        taskRepository.deleteTask(uid);
    }

    public void serviceAddTask(Task task) {
        taskRepository.addTask(task);
    }

}
