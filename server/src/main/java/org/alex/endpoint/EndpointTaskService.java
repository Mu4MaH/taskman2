package org.alex.endpoint;

import org.alex.api.service.ITaskService;
import org.alex.entity.Task;
import org.alex.exception.IllegalArgumentException;
import org.alex.repository.TaskRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class EndpointTaskService implements ITaskService {

    public EndpointTaskService() {
//        Endpoint.publish("http://localhost:888/task", this);
    }

    private final TaskRepository repository = new TaskRepository();

    @WebMethod
    public void create(Task task) {
        if (task == null) {
            return;
        } else {
            repository.add(task);
        }
    }

    @WebMethod
    @Override
    public Task get(String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            return repository.get(uid);
        }
    }

    @WebMethod
    public List<Task> getAll() {
        return repository.getAll();
    }

    @WebMethod
    public void updateTask(String uid, Task task) throws IllegalArgumentException {
        if (uid.isEmpty() || uid.equals(null) || task.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            repository.updateTask(uid, task);
        }
    }

    @WebMethod
    @Override
    public void merge(List<Task> tasks) {
        if (tasks == null) return;
        repository.merge(tasks);
    }

    @WebMethod
    public void delete(String uid) throws IllegalArgumentException {
        if (uid.isEmpty() && uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            repository.delete(uid);
        }
    }

}
