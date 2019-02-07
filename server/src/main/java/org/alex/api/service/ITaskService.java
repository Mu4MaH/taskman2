package org.alex.api.service;

import org.alex.entity.Task;
import org.alex.exception.WrongArgumentTypeException;

import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@XmlTransient
public interface ITaskService {

    void deleteTask(String uid) throws WrongArgumentTypeException;

    void createTask(Task task);

    List<Task> getAllTask();

    Task getTask(String uid) throws WrongArgumentTypeException;

    void updateTask(Task task) throws WrongArgumentTypeException;

    void mergeTasks(List<Task> tasks);

}
