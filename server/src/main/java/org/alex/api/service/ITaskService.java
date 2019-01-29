package org.alex.api.service;

import org.alex.entity.Task;
import org.alex.exception.IllegalArgumentException;

import javax.xml.bind.annotation.XmlTransient;
import java.sql.Connection;
import java.util.List;

@XmlTransient
public interface ITaskService {

    void deleteTask(String uid) throws IllegalArgumentException;

    void createTask(Task task);

    List<Task> getAllTask();

    Task getTask(String uid) throws IllegalArgumentException;

    void updateTask(String uid, Task task) throws IllegalArgumentException;

    void mergeTask(List<Task> tasks);

    void setConnection(Connection connection);
}
