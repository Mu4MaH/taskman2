package org.alex.endpoint;

import org.alex.api.service.IProjectService;
import org.alex.entity.Project;
import org.alex.exception.IllegalArgumentException;
import org.alex.repository.ProjectRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class EndpointProjectService implements IProjectService {

    ProjectRepository repository = new ProjectRepository();

    public EndpointProjectService() {
//        Endpoint.publish("http://localhost:888/project", this);
    }

    @WebMethod
    @Override
    public void create(Project project) {
        if (project == null) return;
        this.repository.add(project);
    }

    @WebMethod
    @Override
    public Project get(String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            return (Project) this.repository.get(uid);
        }
    }

    @WebMethod
    public void delete(String uid) throws IllegalArgumentException {
        //ничего не делает, удаление проектов не разрешено вообще.
    }

    @WebMethod
    @Override
    public List<Project> getAll() {
        return this.repository.getAll();
    }

    @WebMethod
    @Override
    public void merge(List<Project> list) {
        if (list.equals(null)) return;
        this.repository.merge(list);
    }

}


